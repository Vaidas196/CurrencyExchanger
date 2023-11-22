package com.currencyExchanger.codeAcademy;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.thoughtworks.xstream.XStream;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException; // Import this class
import java.io.StringReader;
import java.nio.charset.StandardCharsets; // Import this class
import java.nio.file.Files; // Import this class
import java.nio.file.Paths; // Import this class
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource; // Import this class
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
public class FxRatesController {
    // "https://www.lb.lt/webservices/FxRates/FxRates.asmx?op=getCurrentFxRates";
    List <FxRate> currencyPairList = new ArrayList<>();

    /*@GetMapping("/fxrates")
   public FxRates getFxRates(FxRates fr) throws IOException {
        XStream xStream = new XStream();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        xStream.allowTypesByWildcard(new String[]{"com.currencyExchanger.**"});
        xStream.processAnnotations(FxRates.class);
        xStream.alias("FxRate", FxRate.class);
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        String xmlData = loadXmlFromFile("currentFxRates.xml");
        FxRates fxRates = (FxRates) xStream.fromXML(xmlData);
        currencyPairList = fxRates.getFxRateList();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        return  fxRates;
    }*/






    private String loadXmlFromFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] xmlBytes = Files.readAllBytes(Paths.get(resource.getFile().getPath()));
        return new String(xmlBytes, StandardCharsets.UTF_8);
    }

    private String readCurrentFxRatesDataFromWebsite(){
        final String currencyXmlData ="https://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=eu";
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
    public FxRates getFxRates(FxRates fr) throws IOException {
        XStream xStream = new XStream();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        xStream.allowTypesByWildcard(new String[]{"com.currencyExchanger.**"});
        xStream.processAnnotations(FxRates.class);
        xStream.alias("FxRate", FxRate.class);
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        String xmlData = readCurrentFxRatesDataFromWebsite();
        FxRates fxRates = (FxRates) xStream.fromXML(xmlData);
        //currencyPairList = fxRates.getFxRateList();
        xStream.aliasField("FxRate", FxRates.class, "fxRateList");
        return  fxRates;
    }

}
