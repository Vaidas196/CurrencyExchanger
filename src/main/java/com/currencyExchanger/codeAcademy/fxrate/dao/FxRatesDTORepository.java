package com.currencyExchanger.codeAcademy.fxrate.dao;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface FxRatesDTORepository extends JpaRepository<FxRatesDTO,Long> {

    FxRatesDTO findByCcyTo(String ccy);

    boolean existsByDtAndCcyFromAndCcyTo(String dt, String ccyFrom, String ccyTo);

    List<FxRatesDTO> findByCcyToOrderByDtDesc(String ccyFrom);

    Page<FxRatesDTO> findAll(Pageable pageable);

    FxRatesDTO findById(long id);

}
