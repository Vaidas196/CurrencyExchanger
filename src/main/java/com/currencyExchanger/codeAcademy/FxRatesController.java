package com.currencyExchanger.codeAcademy;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;

@RestController

public class FxRatesController {
    @GetMapping("/fxrates")
    FxRates fxRates() throws XMLStreamException, IOException {
        InputStream xmlResource =   FxRatesController.class.getClassLoader().getResourceAsStream("currentFxRatesCopy.xml");
        ObjectMapper mapper = new XmlMapper();

        FxRates fxRates = mapper.readValue(xmlResource, FxRates.class);
        return fxRates;
    }
}
