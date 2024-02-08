package com.currencyExchanger.codeAcademy.fxrate.dao;


import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface FxRatesDTORepository extends JpaRepository<FxRatesDTO,Long> {

    FxRatesDTO findByCcyTo(String ccy);

    boolean existsByDtAndCcyFromAndCcyTo(String dt, String ccyFrom, String ccyTo);

    List<FxRatesDTO> findByCcyToOrderByDtDesc(String ccyFrom);
}
