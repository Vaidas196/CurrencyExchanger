package com.currencyExchanger.codeAcademy.fxrate.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("FxRates")
public class FxRates {

    @XStreamImplicit
    private List<FxRate> fxRateList = new ArrayList<>();


}
