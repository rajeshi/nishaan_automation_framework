package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class MainAddressPage extends BasePage {

    By mainAddressLineTextBox = By.xpath("//form[preceding-sibling::legend[text()='Main Address']]//textarea[@data-field-name='Address Line']");
    By mainAddressTownCityTextBox = By.xpath("//form[preceding-sibling::legend[text()='Main Address']]//input[@data-field-name='Town/City']");
    By mainAddressPostcodeTextBox = By.xpath("//form[preceding-sibling::legend[text()='Main Address']]//input[@data-field-name='Postcode']");
    By mainAddressCountrySelectBox = By.xpath("//form[preceding-sibling::legend[text()='Main Address']]//select[@data-field-name='Country']");
    By isCorrespondenceAddressCheckBox = By.xpath("//input[@data-field-name='Is your correspondence address different from your main address?']");
    By correspondenceAddressLineTextBox = By.xpath("//div[preceding-sibling::div//legend[text()='Correspondence Address']]//textarea[@data-field-name='Address Line']");
    By correspondenceTownCityTextBox = By.xpath("//div[preceding-sibling::div//legend[text()='Correspondence Address']]//input[@data-field-name='Town/City']");
    By correspondencePostcodeTextBox = By.xpath("//div[preceding-sibling::div//legend[text()='Correspondence Address']]//input[@data-field-name='Postcode']");
    By correspondenceCountrySelectBox = By.xpath("//div[preceding-sibling::div//legend[text()='Correspondence Address']]//select[@data-field-name='Country']");
    By nextButton = By.linkText("Next");
    By previousButton = By.linkText("Back");

    public MainAddressPage enterMainAddressLine(String mainAddressLine) {
        waitForElement(mainAddressLineTextBox).clear();
        waitForElement(mainAddressLineTextBox).sendKeys(mainAddressLine);
        return this;
    }

    public MainAddressPage checkisCorrespondenceAddress(boolean value) {
        checkboxSelection(waitForElement(isCorrespondenceAddressCheckBox), value);
        return this;
    }

    public MainAddressPage enterMainAddressTownCity(String mainAddressTownCity) {
        waitForElement(mainAddressTownCityTextBox).clear();
        waitForElement(mainAddressTownCityTextBox).sendKeys(mainAddressTownCity);
        return this;
    }

    public MainAddressPage enterMainAddressPostcode(String mainAddressPostcode) {
        waitForElement(mainAddressPostcodeTextBox).clear();
        waitForElement(mainAddressPostcodeTextBox).sendKeys(mainAddressPostcode);
        return this;
    }

    public MainAddressPage selectMainAddressCountry(String mainAddressCountry) {
        selectItemByText(waitForElement(mainAddressCountrySelectBox), mainAddressCountry);
        return this;
    }

    public MainAddressPage enterCorrespondenceAddressLine(String correspondenceAddressLine) {
        waitForElement(correspondenceAddressLineTextBox).clear();
        waitForElement(correspondenceAddressLineTextBox).sendKeys(correspondenceAddressLine);
        return this;
    }

    public MainAddressPage enterCorrespondenceTownCity(String correspondenceTownCity) {
        waitForElement(correspondenceTownCityTextBox).clear();
        waitForElement(correspondenceTownCityTextBox).sendKeys(correspondenceTownCity);
        return this;
    }

    public MainAddressPage enterCorrespondencePostcode(String correspondencePostcode) {
        waitForElement(correspondencePostcodeTextBox).clear();
        waitForElement(correspondencePostcodeTextBox).sendKeys(correspondencePostcode);
        return this;
    }

    public MainAddressPage selectCorrespondenceCountry(String correspondenceCountry) {
        selectItemByText(waitForElement(correspondenceCountrySelectBox), correspondenceCountry);
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

    public boolean isMainAddressPageLoad() {
        return isElementPresent(mainAddressLineTextBox);
    }
}
