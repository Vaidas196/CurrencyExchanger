package com.currencyExchanger.codeAcademy;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XStreamAlias("FxRate")
class FxRate {

    
    @XStreamAlias("Tp")
    private String tp;
    @XStreamAlias("Dt")
    private String dt;
    @XStreamImplicit
    private List<CcyAmt> ccyAmt = new ArrayList<>();

}