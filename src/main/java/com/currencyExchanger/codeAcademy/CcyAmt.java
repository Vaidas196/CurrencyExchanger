package com.currencyExchanger.codeAcademy;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("CcyAmt")
class CcyAmt {

    @XStreamAlias("Ccy")
    private String ccy;

    @XStreamAlias("Amt")
    private double amt;

}
