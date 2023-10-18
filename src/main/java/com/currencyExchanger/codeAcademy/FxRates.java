package com.currencyExchanger.codeAcademy;
import lombok.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FxRates {
    private List<FxRate> fxRateList = new ArrayList<>();
}
