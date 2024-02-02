package com.currencyExchanger.codeAcademy.fxrate.dao;


import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxRatesDTORepository extends JpaRepository<FxRatesDTO,Long> {

}
