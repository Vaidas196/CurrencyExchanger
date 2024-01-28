package com.currencyExchanger.codeAcademy.fxrate.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.*;
import java.util.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("FxRates")
public class FxRates {

    @XStreamImplicit
    private List<FxRate> fxRateList = new ArrayList<>();

}
