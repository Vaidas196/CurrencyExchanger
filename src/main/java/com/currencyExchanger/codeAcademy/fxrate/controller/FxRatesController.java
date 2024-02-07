package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.model.ConvertedPair;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class FxRatesController {


    private final FxRatesService fxRatesService;

    @GetMapping("/getfxrates")
    public String getFxRates() throws IOException {
        fxRatesService.getFxRates();
        return "fxrates/administrate";
    }

    @GetMapping("/fxrates")
    public String fxRates(Model model) {
        model.addAttribute("currencies", fxRatesService.displayCurrencyList());
        model.addAttribute("selectedFromCurrency", "EUR");
        model.addAttribute("selectedToCurrency", "EUR");
        model.addAttribute("amountInput",1);
        model.addAttribute("result", 1);

        return "fxrates/fxrates";
    }

    @GetMapping("/administrate")
    public String administration() {
        return "fxrates/administrate";
    }


    @GetMapping("/convert")
    public String convert( @ModelAttribute ConvertedPair convertedPair,Model model,
            @RequestParam("Amount")BigDecimal amount,
            @RequestParam("From") String fromCurrency,
            @RequestParam("To") String toCurrency
            ){
        model.addAttribute("currencies", fxRatesService.displayCurrencyList());
        BigDecimal result = fxRatesService.convertCurrency(amount, fromCurrency, toCurrency);
        model.addAttribute("amountInput", amount);
        model.addAttribute("selectedFromCurrency", fromCurrency);
        model.addAttribute("selectedToCurrency", toCurrency);
        model.addAttribute("result",result);
        return "fxrates/fxrates";
    }

}
