package com.currencyExchanger.codeAcademy.fxrate.dao;

import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@Primary
public class FxRateJPADao implements FxRateDao{

    FxRateRepository fxRateRepository;
    @Override
    public void save(FxRate fxRate) {
        fxRateRepository.save(fxRate);
    }

    @Override
    public void update(FxRate fxRate) {

    }

    @Override
    public List<FxRate> getAll() {
        return null;
    }

    @Override
    public FxRate getFxRateByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteProductByUUID(UUID id) {

    }
}
