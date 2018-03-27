package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class PaymentLandingPage extends BasePage {

    By nextStepButton = By.xpath("//a//span[contains(text(),'Next Step')]");


    public <T extends BasePage> T clickNextStep(Class<T> clazz) {
        waitForElement(nextStepButton).click();
        try {
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new AssertionError("Unable to create a page for the generic class");
        }
    }

    public boolean isNextStepButtonPresent() {
        return isElementPresent(nextStepButton, 45);
    }
}
