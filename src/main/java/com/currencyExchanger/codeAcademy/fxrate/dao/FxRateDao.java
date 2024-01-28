package com.currencyExchanger.codeAcademy.fxrate.dao;

import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface FxRateDao {
    void save(FxRate fxRate);

    void update(FxRate fxRate);

    List<FxRate> getAll();
    FxRate getFxRateByUUID(UUID id);

    void deleteProductByUUID(UUID id);
}
