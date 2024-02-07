package com.currencyExchanger.codeAcademy.fxrate.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Data
@Builder
@Getter
@Setter
public class ConvertedPair {
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal result;
}
