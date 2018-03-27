package com.nishaanx.automation_framework.pages.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TrainingDetailsPage extends BasePage {

    By whenToExpectFinishTextBox = By.xpath("//input[@data-field-name='When are you expected to finish your GP Training?']");
    By undergraduateConductedInEnglishSelectBox = By.xpath("//select[@data-field-name='Was your undergraduate training conducted in English?']");
    By nationalTrainingNumberTextBox = By.xpath("//input[@data-field-name='National Training Number']");
    By whichDeaneryTrainingSelectBox = By.xpath("//select[@data-field-name='Which Deanery are you training with?']");
    By ukMedicalSchoolSelectBox = By.xpath("//select[@data-field-name='UK medical school or country where primary medical qualification was undertaken']");
    By whatTrainingPathwaySelectBox = By.xpath("//select[@data-field-name='What training pathway are you currently undertaking?']");
    By nextButton = By.linkText("Next");
    By previousButton = By.linkText("Back");
    By calendarTable = By.xpath("//*[contains(@class,'show-calendar') and contains(@style,'display: block;')]//*[contains(@class,'calendar') and contains(@class, 'left') and @style='display: block;']//*[@class='calendar-table']");
    By monthSelectBox = By.className("monthselect");
    By yearSelectBox = By.className("yearselect");
    String calendarDayPrefix = ".//td[not(contains(@class,'off') and contains(@class,'available')) and text()='";
    String calendarDaySuffix = "']";

    public TrainingDetailsPage enterWhenToExpectFinish(String whenToExpectFinish) {
        waitForElement(whenToExpectFinishTextBox).click();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = sdf.parse(whenToExpectFinish);
        } catch (ParseException ex) {
            throw new AssertionError("Incorrect Date format");
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM");
        if (isCalendarTableDisplayed()) {
            WebElement monthElement = waitForElement(calendarTable).findElement(monthSelectBox);
            selectItemByText(monthElement, sdf1.format(date));

            String[] splitDate = whenToExpectFinish.split("/");
            WebElement yearElement = waitForElement(calendarTable).findElement(yearSelectBox);
            selectItemByText(yearElement, splitDate[2]);

            WebElement dayElement = waitForElement(calendarTable).findElement(By.xpath(calendarDayPrefix + splitDate[1] + calendarDaySuffix));
            dayElement.click();
        }
        return this;
    }

    private boolean isCalendarTableDisplayed() {
        return isElementPresent(calendarTable, 5);
    }

    public TrainingDetailsPage selectUndergraduateConductedInEnglish(String undergraduateConductedInEnglish) {
        selectItemByText(waitForElement(undergraduateConductedInEnglishSelectBox), undergraduateConductedInEnglish);
        return this;
    }

    public TrainingDetailsPage enterNationalTrainingNumber(String nationalTrainingNumber) {
        waitForElement(nationalTrainingNumberTextBox).clear();
        waitForElement(nationalTrainingNumberTextBox).sendKeys(nationalTrainingNumber);
        return this;
    }

    public TrainingDetailsPage selectWhichDeaneryTraining(String whichDeaneryTraining) {
        selectItemByText(waitForElement(whichDeaneryTrainingSelectBox), whichDeaneryTraining);
        return this;
    }

    public TrainingDetailsPage selectUkMedicalSchool(String ukMedicalSchool) {
        selectItemByText(waitForElement(ukMedicalSchoolSelectBox), ukMedicalSchool);
        return this;
    }

    public TrainingDetailsPage selectWhatTrainingPathway(String whatTrainingPathway) {
        selectItemByText(waitForElement(whatTrainingPathwaySelectBox), whatTrainingPathway);
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

    public boolean isTrainingDetailsPagePresent() {
        return isElementPresent(whatTrainingPathwaySelectBox);
    }
}
