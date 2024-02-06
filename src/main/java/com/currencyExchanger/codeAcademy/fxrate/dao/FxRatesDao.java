package com.currencyExchanger.codeAcademy.fxrate.dao;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
@Primary
public class FxRatesDao {

    FxRatesDTORepository fxRatesDTORepository;
    public void save(FxRatesDTO fxRates) {
        fxRatesDTORepository.save(fxRates);
    }

}
