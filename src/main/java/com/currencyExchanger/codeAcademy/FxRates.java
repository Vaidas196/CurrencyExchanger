package com.currencyExchanger.codeAcademy;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.*;

@JacksonXmlRootElement(localName = "FxRates")
public class FxRates {

    @JacksonXmlElementWrapper (localName = "FxRate",useWrapping = false)
    @JacksonXmlProperty (localName = "FxRate")
    private List<FxRate> fxRateList = new ArrayList<>();

    public FxRates() {
    }

    public FxRates(List<FxRate> fxRateList)
    {
        this.fxRateList = fxRateList;
    }
}
