package com.currencyExchanger.codeAcademy.fxrate.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XStreamAlias("CcyAmt")
public class CcyAmt {
    @Id
    @SequenceGenerator(
            name = "ccy_amt_sequence",
            sequenceName = "ccy_amt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ccy_amt_sequence"
    )
    private Long id;

    @XStreamAlias("Ccy")
    private String ccy;

    @XStreamAlias("Amt")
    private BigDecimal amt;

    public CcyAmt(String ccy, BigDecimal amt) {
        this.ccy = ccy;
        this.amt=amt;
    }

    @Override
    public String toString() {
        return "CcyAmt{" +
                "ccy='" + ccy + '\'' +
                ", amt=" + amt +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
