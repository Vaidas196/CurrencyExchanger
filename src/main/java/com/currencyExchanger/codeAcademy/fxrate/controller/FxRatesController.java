package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.model.ConvertedPair;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class FxRatesController {


    private final FxRatesService fxRatesService;

    @GetMapping("/fxrates")
    public String fxRates(Model model) {
        model.addAttribute("currencies", fxRatesService.displayCurrencyList());
        model.addAttribute("selectedFromCurrency", "EUR");
        model.addAttribute("selectedToCurrency", "EUR");
        model.addAttribute("amountInput",1);
        model.addAttribute("result", 1);

        return "fxrates/fxrates";
    }

    @GetMapping("/convert")
    public String convert(@Valid @ModelAttribute ConvertedPair convertedPair,BindingResult bindingResult, Model model,
                          RedirectAttributes redirectAttributes,
                          @RequestParam("Amount")BigDecimal amount,
                          @RequestParam("From") String fromCurrency,
                          @RequestParam("To") String toCurrency
            ){
        if (bindingResult.hasErrors()){
            model.addAttribute("invalidAmountErrorMessage","Amount should be greater than 0");
            model.addAttribute("currencies", fxRatesService.displayCurrencyList());
            model.addAttribute("selectedFromCurrency", fromCurrency);
            model.addAttribute("selectedToCurrency", toCurrency);
            model.addAttribute("amountInput",1);
            BigDecimal result = fxRatesService.convertCurrency(new BigDecimal(1), fromCurrency, toCurrency);
            model.addAttribute("result",result);

            return "fxrates/fxrates";

        }
            model.addAttribute("currencies", fxRatesService.displayCurrencyList());
            BigDecimal result = fxRatesService.convertCurrency(amount, fromCurrency, toCurrency);
            model.addAttribute("amountInput", amount);
            model.addAttribute("selectedFromCurrency", fromCurrency);
            model.addAttribute("selectedToCurrency", toCurrency);
            model.addAttribute("result",result);
            return "fxrates/fxrates";


    }

}
