package com.nishaanx.automation_framework.pages.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonalDetailsPage extends BasePage {

    By titleSelectBox = By.xpath("//select[@data-field-name='Title']");
    By forenameTextBox = By.xpath("//input[@data-field-name='Forename']");
    By surnameTextBox = By.xpath("//input[@data-field-name='Surname']");
    By dobTextBox = By.xpath("//input[contains(@data-field-name,'Date of birth')]");
    By calendarTable = By.xpath("//*[contains(@class,'show-calendar') and contains(@style,'display: block;')]//*[contains(@class,'calendar') and contains(@class, 'left') and @style='display: block;']//*[@class='calendar-table']");
    By monthSelectBox = By.className("monthselect");
    By yearSelectBox = By.className("yearselect");
    By countryOfBirthSelectBox = By.xpath("//select[@data-field-name='Country of birth']");
    By genderSelectBox = By.xpath("//select[@data-field-name='Gender']");
    By nextButton = By.linkText("Next");
    String calendarDayPrefix = ".//td[not(contains(@class,'off') and contains(@class,'available')) and text()='";
    String calendarDaySuffix = "']";

    public PersonalDetailsPage selectTitle(String title) {
        waitForElement(titleSelectBox).sendKeys(title);
        return this;
    }

    private boolean isCalendarTableDisplayed() {
        return isElementPresent(calendarTable, 5);
    }

    public boolean isPersonalDetailsPagePresent() {
        return isElementPresent(titleSelectBox);
    }

    public PersonalDetailsPage enterForename(String forename) {
        waitForElement(forenameTextBox).clear();
        waitForElement(forenameTextBox).sendKeys(forename);
        return this;
    }

    public PersonalDetailsPage enterSurname(String surname) {
        waitForElement(surnameTextBox).clear();
        waitForElement(surnameTextBox).sendKeys(surname);
        return this;
    }

    public PersonalDetailsPage enterDob(String dob) {
        waitForElement(dobTextBox).click();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dob);
        } catch (ParseException ex) {
            throw new AssertionError("Incorrect Date format");
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM");
        if (isCalendarTableDisplayed()) {
            WebElement monthElement = waitForElement(calendarTable).findElement(monthSelectBox);
            selectItemByText(monthElement, sdf1.format(date));

            String[] splitDate = dob.split("/");
            WebElement yearElement = waitForElement(calendarTable).findElement(yearSelectBox);
            selectItemByText(yearElement, splitDate[2]);

            WebElement dayElement = waitForElement(calendarTable).findElement(By.xpath(calendarDayPrefix + splitDate[1] + calendarDaySuffix));
            dayElement.click();
        }
        return this;
    }

    public PersonalDetailsPage selectCountryOfBirth(String countryOfBirth) {
        selectItemByText(waitForElement(countryOfBirthSelectBox), countryOfBirth);
        return this;
    }

    public PersonalDetailsPage selectGender(String gender) {
        String updatedGender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
        selectItemByText(waitForElement(genderSelectBox), updatedGender);
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
