package com.currencyExchanger.codeAcademy.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("CcyAmt")
public class CcyAmt {

    @XStreamAlias("Ccy")
    private String ccy;

    @XStreamAlias("Amt")
    private BigDecimal amt;

    @Override
    public String toString() {
        return "CcyAmt{" +
                "ccy='" + ccy + '\'' +
                ", amt=" + amt +
                '}';
    }
}
