package com.currencyExchanger.codeAcademy.administrate.service;

import com.currencyExchanger.codeAcademy.fxrate.dao.FxRatesDTORepository;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import com.thoughtworks.xstream.XStream;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AdministrateService {

    private List<FxRate> currencyPairList = new ArrayList<>();
    final String currencyXmlData ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";
    final FxRatesDTORepository fxRatesDTORepository;
    public String readCurrentFxRatesDataFromWebsite(){
        WebClient.Builder builder = WebClient.builder();
        return builder
                .build()
                .get()
                .uri(currencyXmlData)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public void getFxRates() throws IOException {
        XStream xStream = new XStream();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        xStream.allowTypesByWildcard(new String[]{"com.currencyExchanger.**"});
        xStream.processAnnotations(FxRates.class);
        xStream.alias("FxRate", FxRate.class);
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        String xmlData = readCurrentFxRatesDataFromWebsite();
        FxRates fxRates = (FxRates) xStream.fromXML(xmlData);
        currencyPairList = fxRates.getFxRateList();
        saveFxRates();
    }
    public void saveFxRates(){

        //build and save euro to euro field
        try {

                    saveWithUniqueConstraint(
                            FxRatesDTO.builder()
                                    .dt(currencyPairList.get(0).getDt())
                                    .ccyFrom("EUR")
                                    .amtFrom(new BigDecimal(1))
                                    .ccyTo("EUR")
                                    .amtTo(new BigDecimal(1))
                                    .build()
                    );
            for (FxRate fxRate : currencyPairList) {
                //FxRate(id=null,tp=EU,dt=2024-02-01,ccyAmt=[CcyAmt{ccy='EUR', amt=1}, CcyAmt{ccy='AUD', amt=1.6594}])
                saveWithUniqueConstraint(
                        FxRatesDTO.builder()
                                .dt(fxRate.getDt())
                                .ccyFrom(fxRate.getCcyAmt().get(0).getCcy())
                                .amtFrom(fxRate.getCcyAmt().get(0).getAmt())
                                .ccyTo(fxRate.getCcyAmt().get(1).getCcy())
                                .amtTo(fxRate.getCcyAmt().get(1).getAmt())
                                .build()
                );

            }
        } catch (DataIntegrityViolationException e){

            throw new RuntimeException("Todays rates area already loaded!", e);
        }

    }


    private void saveWithUniqueConstraint(FxRatesDTO fxRatesDTO) {
        try {
            // Check if the same data already exists before saving
            if (!fxRatesDTORepository.existsByDtAndCcyFromAndCcyTo(fxRatesDTO.getDt(),
                    fxRatesDTO.getCcyFrom(), fxRatesDTO.getCcyTo())) {
                fxRatesDTORepository.save(fxRatesDTO);
            }
        } catch (DataIntegrityViolationException e) {
            // Handle unique constraint violation
            // For example, you can log the error message and skip saving the duplicate data
            System.err.println("Error: Data already exists. Skipping saving the duplicate data.");
        }
    }
}
