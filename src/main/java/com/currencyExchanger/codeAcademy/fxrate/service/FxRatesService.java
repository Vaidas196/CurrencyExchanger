package com.currencyExchanger.codeAcademy.fxrate.service;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRateDao;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FxRatesService {

    private List<FxRate> currencyPairList = new ArrayList<>();
    final String currencyXmlData ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";

    FxRateDao fxRateDao;
    public String readCurrentFxRatesDataFromWebsite(){
        // prints current FX_Rates
        WebClient.Builder builder = WebClient.builder();
        String fxRates = builder
                .build()
                .get()
                .uri(currencyXmlData)
                .retrieve()
                .bodyToMono(String.class)
                .block();
//        System.out.println("------------");
//        System.out.println(fxRates);
//        System.out.println("------------");
        return fxRates;
    }


    public FxRates getFxRates() throws IOException {
        XStream xStream = new XStream();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        xStream.allowTypesByWildcard(new String[]{"com.currencyExchanger.**"});
        xStream.processAnnotations(FxRates.class);
        xStream.alias("FxRate", FxRate.class);
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        String xmlData = readCurrentFxRatesDataFromWebsite();
        FxRates fxRates = (FxRates) xStream.fromXML(xmlData);
        currencyPairList = fxRates.getFxRateList();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        System.out.println(currencyPairList.get(0));
        return  fxRates;
    }



    public BigDecimal convert() {
        FxRate currencyPair = currencyPairList.get(0);
        BigDecimal sourceFxrate = currencyPairList.get(0).getCcyAmt().get(0).getAmt();
        BigDecimal targetFxrate = currencyPairList.get(0).getCcyAmt().get(1).getAmt();
        BigDecimal multiplier = new BigDecimal(6);
        BigDecimal result = multiplier.multiply(sourceFxrate.multiply(targetFxrate));
        return result;
    }

    public void saveFxRates(){

    }

}
