package com.currencyExchanger.codeAcademy.fxrate.dao;

import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxRateRepository extends JpaRepository<FxRate, Long> {

}
