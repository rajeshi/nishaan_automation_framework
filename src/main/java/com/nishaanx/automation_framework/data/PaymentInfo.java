/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nishaanx.automation_framework.data;

/**
 *
 * @author abc
 */
public class PaymentInfo {

    String cardnumber;
    String cvvnumber;
    String expiryMonth;
    String expiryYear;

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getCvvnumber() {
        return cvvnumber;
    }

    public void setCvvnumber(String cvvnumber) {
        this.cvvnumber = cvvnumber;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

}
