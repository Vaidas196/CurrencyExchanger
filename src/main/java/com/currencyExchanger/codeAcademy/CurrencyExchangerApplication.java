package com.currencyExchanger.codeAcademy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
@SpringBootApplication
public class CurrencyExchangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangerApplication.class, args);

		String url ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";

		// prints current FX_Rates
		WebClient.Builder builder = WebClient.builder();
		String fxRates = builder
				.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		System.out.println("------------");
		System.out.println(fxRates);
		System.out.println("------------");
	}


}
