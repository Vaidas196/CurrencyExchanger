package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.model.CcyAmt;
import com.currencyExchanger.codeAcademy.fxrate.service.FxRatesService;
import com.thoughtworks.xstream.XStream;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRates;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.HttpEndpoints;
@Controller
public class FxRatesController {
    private final FxRatesService fxRatesService = new FxRatesService();
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
