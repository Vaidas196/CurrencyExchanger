package com.currencyExchanger.codeAcademy;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("FxRates")

public class FxRates {

    @XStreamImplicit
    private List<FxRate> fxRateList = new ArrayList<>();

    public List<FxRate> getFxRateList() {
        return fxRateList;
    }

    public void setFxRateList(List<FxRate> fxRateList) {
        this.fxRateList = fxRateList;
    }

    //    @Override
//    public String toString() {
//        return fxRateList.stream()
//                .forEach(fxRate -> fxRate.toString());
//    }


}
