package com.currencyExchanger.codeAcademy;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("CcyAmt")
class CcyAmt {

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
