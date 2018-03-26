package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

/**
 *
 * @author abc
 */
public class HomePage extends BasePage {

    By gmcNumberTextBox = By.xpath("//input[contains(@name,'gmc')]");
    By lastNameTextBox = By.className("lastname");
    By firstNameTextBox = By.className("firstname");
    By emailTextBox = By.className("email");
    By validateDisabledButton = By.xpath("//input[@value='Validate' and @disabled]");
    By validateEnabledButton = By.xpath("//input[@value='Validate' and not(@disabled)]");
    By continueButton = By.xpath("//input[@value='Continue']");

    public HomePage enterGmcNumber(String gmcNumber) {
        waitForElement(gmcNumberTextBox).sendKeys(gmcNumber);
        return this;
    }

    public <T extends BasePage> T clickContinue(Class<T> clazz) {
        waitForElement(continueButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }

    public boolean isContinueButtonDisplayed() {
        return isElementPresent(continueButton);
    }

    public HomePage enterLastName(String lastName) {
        waitForElement(lastNameTextBox).sendKeys(lastName);
        return this;
    }

    public HomePage enterFirstName(String firstName) {
        waitForElement(firstNameTextBox).sendKeys(firstName);
        return this;
    }

    public boolean isFirstNameTextBoxEnabled() {
        return isElementPresent(firstNameTextBox);
    }

    public HomePage enterEmail(String email) {
        waitForElement(emailTextBox).sendKeys(email);
        return this;
    }

    public boolean IsValidateButtonDisabled() {
        return isElementPresent(validateDisabledButton);
    }

    public <T extends BasePage> T clickValidate(Class<T> clazz) {
        waitForElement(validateEnabledButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }
}
