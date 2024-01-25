package com.currencyExchanger.codeAcademy.fxrate.model;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XStreamAlias("FxRate")
public class FxRate {

    @Id
    @SequenceGenerator(
            name = "fx_rate_sequence",
            sequenceName = "fx_rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fx_rate_sequence"
    )
    private Long id;
    @XStreamAlias("Tp")
    private String tp;
    @XStreamAlias("Dt")
    private String dt;


    public FxRate(String tp, String dt) {
        this.tp=tp;
        this.dt=dt;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}