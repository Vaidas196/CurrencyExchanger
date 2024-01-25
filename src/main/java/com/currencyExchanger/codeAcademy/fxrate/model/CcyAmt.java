package com.currencyExchanger.codeAcademy.fxrate.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XStreamAlias("CcyAmt")
public class CcyAmt {

    @XStreamAlias("Ccy")
    private String ccy;

    @XStreamAlias("Amt")
    private BigDecimal amt;
    @Id
    @GeneratedValue
    private Long id;

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
