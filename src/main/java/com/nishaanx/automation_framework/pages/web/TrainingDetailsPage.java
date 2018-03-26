package com.nishaanx.automation_framework.pages.web;

import org.openqa.selenium.By;

public class TrainingDetailsPage extends BasePage {

    By whenToExpectFinishTextBox = By.xpath("//input[@data-field-name='When are you expected to finish your GP Training?']");
    By undergraduateConductedInEnglishSelectBox = By.xpath("//select[@data-field-name='Was your undergraduate training conducted in English?']");
    By nationalTrainingNumberTextBox = By.xpath("//input[@data-field-name='National Training Number']");
    By whichDeaneryTrainingSelectBox = By.xpath("//select[@data-field-name='Which Deanery are you training with?']");
    By ukMedicalSchoolSelectBox = By.xpath("//select[@data-field-name='UK medical school or country where primary medical qualification was undertaken']");
    By whatTrainingPathwaySelectBox = By.xpath("//select[@data-field-name='What training pathway are you currently undertaking?']");
    By nextButton = By.linkText("Next");
    By previousButton = By.linkText("Back");

    public TrainingDetailsPage enterwhenToExpectFinish(String whenToExpectFinish) {
        waitForElement(whenToExpectFinishTextBox).sendKeys(whenToExpectFinish);
        return this;
    }

    public TrainingDetailsPage selectundergraduateConductedInEnglish(String undergraduateConductedInEnglish) {
        selectItemByText(waitForElement(undergraduateConductedInEnglishSelectBox), undergraduateConductedInEnglish);
        return this;
    }

    public TrainingDetailsPage enternationalTrainingNumber(String nationalTrainingNumber) {
        waitForElement(nationalTrainingNumberTextBox).sendKeys(nationalTrainingNumber);
        return this;
    }

    public TrainingDetailsPage selectwhichDeaneryTraining(String whichDeaneryTraining) {
        selectItemByText(waitForElement(whichDeaneryTrainingSelectBox), whichDeaneryTraining);
        return this;
    }

    public TrainingDetailsPage selectukMedicalSchool(String ukMedicalSchool) {
        selectItemByText(waitForElement(ukMedicalSchoolSelectBox), ukMedicalSchool);
        return this;
    }

    public TrainingDetailsPage selectwhatTrainingPathway(String whatTrainingPathway) {
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
}
