package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class CommunicationDetailsPage extends BasePage {

    By emailTextBox = By.xpath("//input[@data-field-name='Email']");
    By phoneTextBox = By.xpath("//input[@data-field-name='Phone']");
    By nextButton = By.linkText("Next");
    By previousButton = By.linkText("Back");

    public CommunicationDetailsPage enterEmail(String email) {
        waitForElement(emailTextBox).sendKeys(email);
        return this;
    }

    public CommunicationDetailsPage enterPhone(String phone) {
        waitForElement(phoneTextBox).sendKeys(phone);
        return this;
    }

    public <T extends BasePage> T clickNext(Class<T> clazz) {
        waitForElement(nextButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }

    public <T extends BasePage> T clickPrevious(Class<T> clazz) {
        waitForElement(previousButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }
}
