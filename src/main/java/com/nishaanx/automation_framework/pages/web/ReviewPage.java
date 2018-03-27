package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class ReviewPage extends BasePage {

    By editPersonalDetailsButton = By.xpath("//div[preceding-sibling::div//legend[text()='Personal Details']]//button[contains(text(),'Edit')]");
    By editCommunicationDetailsButton = By.xpath("//div[preceding-sibling::div//legend[text()='Communication Details']]//button[contains(text(),'Edit')]");
    By editMainAddressButton = By.xpath("//div[preceding-sibling::div//legend[text()='Main Address']]//button[contains(text(),'Edit')]");
    By editTrainingDetailsButton = By.xpath("//div[preceding-sibling::div//legend[text()='Training Details']]//button[contains(text(),'Edit')]");
    By editTermsAndConditionsButton = By.xpath("//div[preceding-sibling::div//legend[text()='Terms and Conditions']]//button[contains(text(),'Edit')]");
    By submitButton = By.xpath("//li[contains(@style,'display: list-item;')]//button//span[text()='Submit']");
    By previousButton = By.linkText("Back");
    By messageText = By.xpath("//div[@class='pop-up-successMsg' and @style='display: block;']");
    By nextStepButton = By.xpath("//a[@style='display: inline-block;']//span[contains(text(),'Next Step')]");

    public PaymentLandingPage clickNextStep() {
        waitForElement(nextStepButton).click();
        return new PaymentLandingPage();
    }

    public PersonalDetailsPage clickPersonalDetails() {
        waitForElement(editPersonalDetailsButton).click();
        return new PersonalDetailsPage();
    }

    public String getMessageText() {
        return waitForElement(messageText).getText();
    }

    public boolean isMessageTextPresent() {
        return isElementPresent(editPersonalDetailsButton, 15);
    }

    public CommunicationDetailsPage clickCommunicationDetails() {
        waitForElement(editCommunicationDetailsButton).click();
        return new CommunicationDetailsPage();
    }

    public MainAddressPage clickMainAddress() {
        waitForElement(editMainAddressButton).click();
        return new MainAddressPage();
    }

    public TrainingDetailsPage clickTrainingDetails() {
        waitForElement(editTrainingDetailsButton).click();
        return new TrainingDetailsPage();
    }

    public TermsAndConditionsPage clickTermsAndConditions() {
        waitForElement(editTermsAndConditionsButton).click();
        return new TermsAndConditionsPage();
    }

    public <T extends BasePage> T clickSubmit(Class<T> clazz) {
        waitForElement(submitButton).click();
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

    public boolean isNextStepButtonPresent() {
        return isElementPresent(nextStepButton, 20);
    }
}
