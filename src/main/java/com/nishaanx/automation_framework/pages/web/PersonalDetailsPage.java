package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class PersonalDetailsPage extends BasePage {

    By titleSelectBox = By.xpath("//select[@data-field-name='Title']");
    By forenameTextBox = By.xpath("//input[@data-field-name='Forename']");
    By surnameTextBox = By.xpath("//input[@data-field-name='Surname']");
    By dobTextBox = By.xpath("//input[contains(@data-field-name,'Date of birth')]");
    By countryOfBirthSelectBox = By.xpath("//select[@data-field-name='Country of birth']");
    By genderSelectBox = By.xpath("//select[@data-field-name='Gender']");
    By nextButton = By.linkText("Next");

    public PersonalDetailsPage selectTitle(String title) {
        waitForElement(titleSelectBox).sendKeys(title);
        return this;
    }

    public PersonalDetailsPage enterForename(String forename) {
        waitForElement(forenameTextBox).sendKeys(forename);
        return this;
    }

    public PersonalDetailsPage enterSurname(String surname) {
        waitForElement(surnameTextBox).sendKeys(surname);
        return this;
    }

    public PersonalDetailsPage enterDob(String dob) {
        waitForElement(dobTextBox).sendKeys(dob);
        return this;
    }

    public PersonalDetailsPage selectCountryOfBirth(String countryOfBirth) {
        selectItemByText(waitForElement(countryOfBirthSelectBox), countryOfBirth);
        return this;
    }

    public PersonalDetailsPage selectGender(String gender) {
        selectItemByText(waitForElement(genderSelectBox), gender);
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
}
