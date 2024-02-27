    package com.currencyExchanger.codeAcademy.administrate.controller;

    import com.currencyExchanger.codeAcademy.administrate.service.AdministrateService;
    import com.currencyExchanger.codeAcademy.fxrate.dto.FxRatesDTO;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.data.domain.Pageable;

    import java.io.IOException;
    import java.math.BigDecimal;

    @Controller
    @RequiredArgsConstructor
    public class AdministrateController {
        private final AdministrateService administrateService;

        @GetMapping("/administrate")
        public String administration() {
            return "administrate/administrate";
        }
        @GetMapping("/administrate/list")
        public String administrateList(Model model, Pageable pageable){
            Page<FxRatesDTO> page = administrateService.getAllCurrencies(pageable);
            model.addAttribute("fxRatesPage", page);
            return "administrate/list";
        }
        @PostMapping("/administrate/getfxrates")
        public String getFxRates() throws IOException {
            administrateService.getFxRates();
            return "administrate/administrate";
        }
        @GetMapping("/administrate/addfxrate")
        public String showAddFxrate(){
            return "administrate/addfxrate";
        }

        @PostMapping("/administrate/addfxrate")
        public String addNewFxRate(@ModelAttribute @Valid FxRatesDTO fxRatesDTO,
                              @RequestParam("currencyName") String currencyName,
                              @RequestParam("currencyRate") BigDecimal currencyRate
        ){
            administrateService.saveCurrency(currencyName,currencyRate);

            return "redirect:/administrate/list";
        }
        @GetMapping("/administrate/updatefxrate/{id}")
        public String updateFxRateMvc(@PathVariable Long id, Model model){
            model.addAttribute("fxRate", administrateService.getFxRateById(id));
            return "administrate/updatefxrate";
        }

        @PostMapping("/administrate/updatefxrate/{id}")
        public String updateFxRate(@PathVariable Long id,
                                   @ModelAttribute ("fxRate") FxRatesDTO fxRatesDTO){
            FxRatesDTO existingFxRate = administrateService.getFxRateById(id);
            existingFxRate.setAmtTo(fxRatesDTO.getAmtTo());
            administrateService.updateFxRate(existingFxRate);
            return "redirect:/administrate/list";
        }
        @GetMapping("/administrate/{id}")
        public String deleteFxRate(@PathVariable Long id,
                                   @ModelAttribute ("fxRate") FxRatesDTO fxRatesDTO){
            administrateService.deleteFxRateById(id);
            return "redirect:/administrate/list";
        }
    }
