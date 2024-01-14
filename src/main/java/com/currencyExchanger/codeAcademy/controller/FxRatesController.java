package com.currencyExchanger.codeAcademy.controller;
import com.thoughtworks.xstream.XStream;
import com.currencyExchanger.codeAcademy.model.FxRates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.client.WebClient;
import com.currencyExchanger.codeAcademy.model.FxRate;
@RestController
public class FxRatesController {
    final String currencyXmlData ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";
    List<FxRate> currencyPairList = new ArrayList<>();

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


    @GetMapping("/fxrates")
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
    @GetMapping("/getfirst")
    public FxRate getFirstFxRate() {
        // Retrieve the first FxRate from the list
        return currencyPairList.isEmpty() ? null : currencyPairList.get(0);
    }

    @GetMapping("/calculate")
    public BigDecimal convert() {
        FxRate currencyPair = currencyPairList.get(0);
        BigDecimal sourceFxrate = currencyPairList.get(0).getCcyAmt().get(0).getAmt();
        BigDecimal targetFxrate = currencyPairList.get(0).getCcyAmt().get(1).getAmt();
        BigDecimal multiplier = new BigDecimal(6);
        BigDecimal result = multiplier.multiply(sourceFxrate.multiply(targetFxrate));
        return result;
    }

}
