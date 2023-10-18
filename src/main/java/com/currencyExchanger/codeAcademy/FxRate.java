package com.currencyExchanger.codeAcademy;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
class FxRate {
    private String tp;
    private String dt;
    private List<CcyAmt> ccyAmt = new ArrayList<>();
}