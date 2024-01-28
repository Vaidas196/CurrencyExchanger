package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class FxRatesController {


    private final FxRatesService fxRatesService;
    @ResponseBody
    @GetMapping("/getfxrates")
    public FxRates getFxRates() throws IOException {
        return  fxRatesService.getFxRates();
    }
    @GetMapping("/fxrates")
    public String converter(Model model) {
        //model.addAttribute("message", "Convert currency!");
        return "fxrates/fxrates";
    }
    @GetMapping("/administrate")
    public String administration(Model model) {
        //model.addAttribute("message", "Convert currency!");
        return "fxrates/administrate";
    }
}
