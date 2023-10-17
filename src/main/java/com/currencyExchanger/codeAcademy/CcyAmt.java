package com.currencyExchanger.codeAcademy;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;
@Data


@JacksonXmlRootElement(localName = "CcyAmt")
class CcyAmt {


    @JacksonXmlProperty(localName = "Ccy")
    private String ccy;

    @JacksonXmlProperty(localName = "Amt")
    private double amt;



    public CcyAmt() {
    }

    public CcyAmt(String ccy) {
        this.ccy = ccy;
    }

    public CcyAmt(double amt) {
        this.amt = amt;
    }

    public CcyAmt(String ccy, double amt) {
        this.ccy = ccy;
        this.amt = amt;
    }

    // Getters and setters

    @JacksonXmlProperty(localName = "Ccy")
    public String getCcy() {
        return ccy;
    }
    @JacksonXmlProperty(localName = "Ccy")
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @JacksonXmlProperty(localName = "Amt")
    public double getAmt() {
        return amt;
    }
    @JacksonXmlProperty(localName = "Amt")
    public void setAmt(double amt) {
        this.amt = amt;
    }
}
