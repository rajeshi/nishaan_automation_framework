package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage {

    By cardNumberTextBox = By.name("credit_card[number]");
    By monthTextBox = By.name("credit_card[month]");
    By yearTextBox = By.name("credit_card[year]");
    By cvvTextBox = By.name("credit_card[verification_value]");
    By submitButton = By.name("credit_card_form");

    public PaymentPage enterCardNumber(String cardNumber) {
        waitForElement(cardNumberTextBox).sendKeys(cardNumber);
        return this;
    }

    public PaymentPage enterMonth(String month) {
        waitForElement(monthTextBox).sendKeys(month);
        return this;
    }

    public PaymentPage enterYear(String year) {
        waitForElement(yearTextBox).sendKeys(year);
        return this;
    }

    public PaymentPage enterCvv(String cvv) {
        waitForElement(cvvTextBox).sendKeys(cvv);
        return this;
    }

    public <T extends BasePage> T clickSubmit(Class<T> clazz) {
        waitForElement(submitButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }

    public boolean isPaymentPageDisplayed() {
        return isElementPresent(cardNumberTextBox);
    }
}
