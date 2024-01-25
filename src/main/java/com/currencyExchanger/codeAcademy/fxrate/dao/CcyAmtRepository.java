package com.currencyExchanger.codeAcademy.fxrate.dao;

import com.currencyExchanger.codeAcademy.fxrate.model.CcyAmt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcyAmtRepository extends JpaRepository<CcyAmt,Long> {

}
