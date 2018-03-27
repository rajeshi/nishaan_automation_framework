package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class TermsAndConditionsPage extends BasePage {

    By rcgpMemberDirectoryCheckBox = By.xpath("//input[@data-field-name='I would like to opt-in to display my name in the RCGP Member Directory']");
    By optinForNewsletterFromRcgpCheckBox = By.xpath("//input[@data-field-name='I would like to opt-in to receive newsletter communication from RCGP']");
    By agreeToTermsAndConditionsCheckBox = By.xpath("//input[@data-field-name='I have read and agree to the Terms and Conditions']");
    By nextButton = By.linkText("Next");
    By previousButton = By.linkText("Back");

    public TermsAndConditionsPage checkRcgpMemberDirectoryCheckBox(boolean value) {
        checkboxSelection(waitForElement(rcgpMemberDirectoryCheckBox), value);
        return this;
    }

    public TermsAndConditionsPage checkOptinForNewsletterFromRcgp(boolean value) {
        checkboxSelection(waitForElement(optinForNewsletterFromRcgpCheckBox), value);
        return this;
    }

    public TermsAndConditionsPage checkAgreeToTermsAndConditions(boolean value) {
        checkboxSelection(waitForElement(agreeToTermsAndConditionsCheckBox), value);
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

    public boolean isTermsAndConditionsPagePresent() {
        return isElementPresent(optinForNewsletterFromRcgpCheckBox);
    }
}
