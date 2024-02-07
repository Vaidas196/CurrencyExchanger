package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.model.ConvertedPair;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
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

//    @ResponseBody
//    @GetMapping("/getfxrates")
//    public FxRates getFxRates() throws IOException {
//        return fxRatesService.getFxRates();
//    }

    @GetMapping("/getfxrates")
    public String getFxRates() throws IOException {
        fxRatesService.getFxRates();
        return "fxrates/administrate";
    }

    @GetMapping("/fxrates")
    public String fxRates(Model model) {
        model.addAttribute("currencies", fxRatesService.displayCurrencyList());
        return "fxrates/fxrates";
    }

    @GetMapping("/administrate")
    public String administration() {
        return "fxrates/administrate";
    }

    @ResponseBody
    @GetMapping("/convert")
    public BigDecimal convert( @ModelAttribute ConvertedPair convertedPair,Model model,
            @RequestParam("Amount")BigDecimal amount,
            @RequestParam("From") String fromCurrency,
            @RequestParam("To") String toCurrency
            ){
        model.addAttribute("convertedPair",convertedPair);
        return fxRatesService.convertCurrency(amount, fromCurrency, toCurrency);
    }
   @ResponseBody
    @GetMapping ("/testConverter")
    public BigDecimal test() {
        return fxRatesService.convertCurrency(new BigDecimal(62), "GBP", "PLN");
    }


}
