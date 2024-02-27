package com.currencyExchanger.codeAcademy.fxrate.service;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRatesDTORepository;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FxRatesService {


    final FxRatesDTORepository fxRatesDTORepository;
    public List<String> displayCurrencyList(){

        Stream<FxRatesDTO> fxRateStream = fxRatesDTORepository.findAll().stream();
        return  fxRateStream
                .map(FxRatesDTO::getCcyTo) // Extracting currency codes
                .distinct() // Ensuring unique currency codes
                .collect(Collectors.toList()); // Collecting into a list

    }

    public BigDecimal convertCurrency(BigDecimal AmountToConvert, String ccyFrom, String ccyTo){
        if (ccyFrom.equals(ccyTo)){
            return AmountToConvert;
        }
        List<FxRatesDTO> fromRates = fxRatesDTORepository.findByCcyToOrderByDtDesc(ccyFrom);
        List<FxRatesDTO> toRates = fxRatesDTORepository.findByCcyToOrderByDtDesc(ccyTo);

        // Get the latest entries
        FxRatesDTO latestFromRate = fromRates.stream().findFirst().orElse(null);
        FxRatesDTO latestToRate = toRates.stream().findFirst().orElse(null);

        // Check if any rates are missing
        if (latestFromRate == null || latestToRate == null) {
            throw new RuntimeException("Missing currency rate data.");
        }

        BigDecimal convertFrom = latestFromRate.getAmtTo();
        BigDecimal convertTo = latestToRate.getAmtTo();
        BigDecimal amountInEur = AmountToConvert.divide(convertFrom,8, RoundingMode.HALF_UP);
        return amountInEur.multiply(convertTo);
    }


}
