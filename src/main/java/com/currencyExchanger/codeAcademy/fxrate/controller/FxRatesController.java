package com.currencyExchanger.codeAcademy.fxrate.controller;
import com.currencyExchanger.codeAcademy.fxrate.model.CcyAmt;
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
import org.springframework.web.reactive.function.client.WebClient;
import com.currencyExchanger.codeAcademy.fxrate.model.FxRate;
import com.currencyExchanger.codeAcademy.HttpEndpoints;
@Controller
public class FxRatesController {
    final String currencyXmlData ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";
    private List<FxRate> currencyPairList = new ArrayList<>();
    private List<CcyAmt> ccyAmt = new ArrayList<>();

    private String loadXmlFromFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] xmlBytes = Files.readAllBytes(Paths.get(resource.getFile().getPath()));
        return new String(xmlBytes, StandardCharsets.UTF_8);
    }

    private String readCurrentFxRatesDataFromWebsite(){
        // prints current FX_Rates
        WebClient.Builder builder = WebClient.builder();
        String fxRates = builder
                .build()
                .get()
                .uri(currencyXmlData)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        System.out.println("------------");
        System.out.println(fxRates);
        System.out.println("------------");
        return fxRates;
    }


    @GetMapping("/getfxrates")
    public FxRates getFxRates() throws IOException {
        XStream xStream = new XStream();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        xStream.allowTypesByWildcard(new String[]{"com.currencyExchanger.**"});
        xStream.processAnnotations(FxRates.class);
        xStream.alias("FxRate", FxRate.class);
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        String xmlData = readCurrentFxRatesDataFromWebsite();
        FxRates fxRates = (FxRates) xStream.fromXML(xmlData);
        currencyPairList = fxRates.getFxRateList();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        return  fxRates;
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


     //needs redoing to parse data from db
    @GetMapping("/calculate")
    public BigDecimal convert() {
        FxRate currencyPair = currencyPairList.get(0);
        BigDecimal sourceFxrate = currencyPairList.get(0).getCcyAmt().get(0).getAmt();
        BigDecimal targetFxrate = currencyPairList.get(0).getCcyAmt().get(1).getAmt();
        BigDecimal multiplier = new BigDecimal(6);
        BigDecimal result = multiplier.multiply(sourceFxrate.multiply(targetFxrate));
        return result;
    }

    public void switchFxRateFieldSides(){}



}
