package com.currencyExchanger.codeAcademy;
import com.thoughtworks.xstream.XStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException; // Import this class
import java.nio.charset.StandardCharsets; // Import this class
import java.nio.file.Files; // Import this class
import java.nio.file.Paths; // Import this class
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource; // Import this class

@RestController
public class FxRatesController {
    final String currencyXmlData = "https://www.lb.lt/webservices/FxRates/FxRates.asmx?op=getCurrentFxRates";
    List <FxRate> currencyPairList = new ArrayList<>();

    @GetMapping("/fxrates")
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
    }

    private String loadXmlFromFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] xmlBytes = Files.readAllBytes(Paths.get(resource.getFile().getPath()));
        return new String(xmlBytes, StandardCharsets.UTF_8);
    }

    @GetMapping ("/getpairs")
    public void getCurrencyPairList(){
        System.out.println(currencyPairList);
    }

}
