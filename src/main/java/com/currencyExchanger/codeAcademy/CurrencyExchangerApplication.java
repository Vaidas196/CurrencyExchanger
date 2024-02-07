package com.currencyExchanger.codeAcademy;
import com.currencyExchanger.codeAcademy.fxrate.dao.CcyAmtRepository;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRateRepository;
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

	CommandLineRunner commandLineRunner(FxRateRepository fxRaterepository, CcyAmtRepository ccyAmtRepository){
		return args ->{

		};
	}

}
