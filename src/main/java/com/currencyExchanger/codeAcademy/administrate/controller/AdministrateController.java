package com.currencyExchanger.codeAcademy.administrate.controller;

import com.currencyExchanger.codeAcademy.administrate.service.AdministrateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdministrateController {
    private final AdministrateService administrateService;

    @GetMapping("/administrate")
    public String administration() {
        return "administrate/administrate";
    }
    @PostMapping("/administrate/getfxrates")
    public String getFxRates() throws IOException {
        administrateService.getFxRates();
        return "administrate/administrate";
    }
}
