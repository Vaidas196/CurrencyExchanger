package com.currencyExchanger.codeAcademy;
import com.currencyExchanger.codeAcademy.fxrate.dao.CcyAmtRepository;
import com.currencyExchanger.codeAcademy.fxrate.dao.FxRateRepository;
import com.currencyExchanger.codeAcademy.fxrate.model.CcyAmt;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
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
			fxRaterepository.saveAll(
					List.of(
							new FxRate("LT", "2024-01-25")

					)

			);
			ccyAmtRepository.saveAll(
					List.of(
							new CcyAmt("EUR",new BigDecimal("1")),
							new CcyAmt("AED",new BigDecimal("4.081270")),
							new CcyAmt("AFN", new BigDecimal("78.495170")),
							new CcyAmt("ALL", new BigDecimal("104.041660")),
							new CcyAmt("AMD", new BigDecimal("450.202680")),
							new CcyAmt("ARS", new BigDecimal("897.821820")),
							new CcyAmt("AUD", new BigDecimal("1.6520")),
							new CcyAmt("AZN", new BigDecimal("1.889040")),
							new CcyAmt("BAM", new BigDecimal("1.960710")),
							new CcyAmt("BDT", new BigDecimal("121.9542")),
							new CcyAmt("BGN", new BigDecimal("1.9558"))

					)
			);

		};
	}

}
