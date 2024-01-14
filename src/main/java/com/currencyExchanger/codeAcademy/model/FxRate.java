package com.currencyExchanger.codeAcademy.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("FxRate")
public class FxRate {


    @XStreamAlias("Tp")
    private String tp;
    @XStreamAlias("Dt")
    private String dt;
    @XStreamImplicit
    private List<CcyAmt> ccyAmt = new ArrayList<>();

}