package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FxRatesController {


    private final FxRatesService fxRatesService;

    @ResponseBody
    @GetMapping("/getfxrates")
    public FxRates getFxRates() throws IOException {
        return fxRatesService.getFxRates();
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

//    @GetMapping("/convert")
//    public String convert(
//            @RequestParam("Amount")BigDecimal amount,
//            @RequestParam("From") String fromCurrency,
//            @RequestParam("To") String toCurrency
//            ){
//        fxRatesService.
//    }
   @ResponseBody
    @GetMapping ("/test")
    public BigDecimal test() {
        return fxRatesService.convertCurrency(new BigDecimal(1), "GBP", "PLN");
    }


}
