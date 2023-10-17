package com.currencyExchanger.codeAcademy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@ToString
@Data

//@JacksonXmlRootElement(localName = "FxRate")
class FxRate {

   // @JsonIgnore
    CcyAmt ccyAmtObj = new CcyAmt();




    @JacksonXmlProperty(localName = "Tp")
    private String tp;

    @JacksonXmlProperty(localName = "Dt")
    private String dt;

    @JacksonXmlElementWrapper(localName = "CcyAmt", useWrapping = false)
    @JacksonXmlProperty(localName = "CcyAmt")
    private List<CcyAmt> ccyAmt = new ArrayList<>();

    /*@JacksonXmlProperty(localName = "Ccy")
    public void setCcy(String ccy) {
        CcyAmt ccyAmtTest = new CcyAmt(ccy);
        //ccyAmtObj.setCcy(ccy);
    }*/

    @JacksonXmlProperty(localName = "Ccy")
    public void setCcy( String ccy) {

    }

    @JacksonXmlProperty(localName = "Amt")
    public void setAmt(double amt) {
        ccyAmtObj.setAmt(amt);
    }


    public FxRate() {
    }

    public FxRate(String tp) {
        this.tp = tp;
    }

    public FxRate(List<CcyAmt> ccyAmt) {
        this.ccyAmt = ccyAmt;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    @JacksonXmlElementWrapper(localName = "CcyAmt")
    @JacksonXmlProperty(localName = "CcyAmt")
    public List<CcyAmt> getCcyAmt() {
        return ccyAmt;
    }

    @JacksonXmlElementWrapper(localName = "CcyAmt")
    @JacksonXmlProperty(localName = "CcyAmt")
    public void setCcyAmt(List<CcyAmt> ccyAmt) {
        this.ccyAmt = ccyAmt;
    }


}