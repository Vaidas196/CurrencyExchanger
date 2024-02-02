package com.currencyExchanger.codeAcademy.fxrate.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class FxRatesDTO {


    @Id
    @GeneratedValue
    private Long id;
    private String dt;
    private String ccyFrom;
    private BigDecimal amtFrom;
    private String ccyTo;
    private BigDecimal amtTo;

}
