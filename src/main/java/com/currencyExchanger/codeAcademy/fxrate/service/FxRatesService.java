package com.currencyExchanger.codeAcademy.fxrate.service;
import com.currencyExchanger.codeAcademy.Currencies;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRateDao;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRatesDTORepository;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import com.currencyExchanger.codeAcademy.fxrate.model.ConvertedPair;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import com.thoughtworks.xstream.XStream;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FxRatesService {


    final FxRatesDTORepository fxRatesDTORepository;
    public List<String> displayCurrencyList(){
        return Currencies.currencies;
    }

    public BigDecimal convertCurrency(BigDecimal AmountToConvert, String ccyFrom, String ccyTo){
        if (ccyFrom.equals(ccyTo)){
            return AmountToConvert;
        }
        BigDecimal convertFrom = fxRatesDTORepository.findByCcyTo(ccyFrom).getAmtTo();
        BigDecimal convertTo = fxRatesDTORepository.findByCcyTo(ccyTo).getAmtTo();
        BigDecimal amountInEur = AmountToConvert.divide(convertFrom,8, RoundingMode.HALF_UP);
        return amountInEur.multiply(convertTo);
    }

}
