package com.currencyExchanger.codeAcademy.fxrate.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
@Data
@Builder
@Getter
@Setter
public class ConvertedPair {
    @Positive
    private BigDecimal amount;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal result;
}
