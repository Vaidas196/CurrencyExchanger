package com.currencyExchanger.codeAcademy;
import com.currencyExchanger.codeAcademy.fxrate.dao.CcyAmtRepository;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRateRepository;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRatesDTORepository;
import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
import com.currencyExchanger.codeAcademy.fxrate.model.CcyAmt;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication

public class CurrencyExchangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangerApplication.class, args);

	}
	@Bean

	CommandLineRunner commandLineRunner(FxRatesDTORepository fxRatesDTORepository ){
		return args ->{
			//to check if latest rates are taken to convert
//			fxRatesDTORepository.save(
//					new FxRatesDTO(null,"2025-01-01","EUR",new BigDecimal(1),"AED", new BigDecimal("0.5"))
//			);
		};
	}

}
