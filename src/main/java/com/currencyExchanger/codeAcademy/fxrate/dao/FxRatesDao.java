package com.currencyExchanger.codeAcademy.fxrate.dao;

import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;

import java.util.List;
import java.util.UUID;

public class FxRatesDao {

    FxRatesDTORepository fxRatesDTORepository;
    public void save(FxRatesDTO fxRates) {
        fxRatesDTORepository.save(fxRates);
    }


    public void update(FxRate fxRate) {

    }


    public List<FxRate> getAll() {
        return null;
    }


    public FxRate getFxRateByUUID(UUID id) {
        return null;
    }


    public void deleteProductByUUID(UUID id) {

    }
}
