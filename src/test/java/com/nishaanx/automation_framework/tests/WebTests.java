package com.nishaanx.automation_framework.tests;

import com.nishaanx.automation_framework.base.Configurations;
import com.nishaanx.automation_framework.data.WorkflowInfo;
import com.nishaanx.automation_framework.enums.WorkflowEnums;
import com.nishaanx.automation_framework.pages.web.CommunicationDetailsPage;
import com.nishaanx.automation_framework.pages.web.HomePage;
import com.nishaanx.automation_framework.pages.web.LoginPage;
import com.nishaanx.automation_framework.pages.web.MainAddressPage;
import com.nishaanx.automation_framework.pages.web.PersonalDetailsPage;
import com.nishaanx.automation_framework.pages.web.ReviewPage;
import com.nishaanx.automation_framework.pages.web.TermsAndConditionsPage;
import com.nishaanx.automation_framework.pages.web.TrainingDetailsPage;
import com.nishaanx.automation_framework.workflow.NishaanxWorkflowImpl;
import com.nishaanx.automation_framework.workflow.NishaanxWorkflows;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTests extends BaseTests {

    @Test(dataProvider = "testData")
    public void testCreationOfAWorkflow(WorkflowInfo workflowInfo) {
        NishaanxWorkflows nw = new NishaanxWorkflowImpl();
        HomePage homePage = nw.navigateToTheUrl(Configurations.URL);

        assertTrue(homePage.IsValidateButtonDisabled(), "Home Page is not loaded!!!");
        LoginPage loginPage = nw.fillValidationInformation(homePage, workflowInfo.getValidationInfo());

        assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is not loaded!!!");
        PersonalDetailsPage personalDetailsPage = nw.loginToTheSystem(loginPage, workflowInfo.getValidationInfo().getEmail(), "RCGP1234");

        assertTrue(personalDetailsPage.isPersonalDetailsPagePresent(), "Person Details Page is not loaded!!!");
        CommunicationDetailsPage communicationsDetailsPage = nw.enterPersonalDetails(personalDetailsPage, workflowInfo.getPersonalDetailsInfo());

        assertTrue(communicationsDetailsPage.isCommunicationDetailsPagePresent(), "Communication Details Page is not loaded!!!");
        MainAddressPage mainAddressPage = nw.enterCommunicationDetails(communicationsDetailsPage, workflowInfo.getCommunicationDetailsInfo());

        assertTrue(mainAddressPage.isMainAddressPageLoad(), "Main Address Page is not loaded!!!");
        TrainingDetailsPage trainingDetailsPage = nw.enterMainAddressDetails(mainAddressPage, workflowInfo.getMainAddressInfo());

        assertTrue(trainingDetailsPage.isTrainingDetailsPagePresent(), "Training Details page is not present!!!");
        TermsAndConditionsPage termsAndConditonsPage = nw.enterTrainingDetails(trainingDetailsPage, workflowInfo.getTrainingDetailsInfo());

        assertTrue(termsAndConditonsPage.isTermsAndConditionsPagePresent(), "Terms and Conditions Page not present!!!");
        ReviewPage reviewPage = nw.acceptTermsAndConditions(termsAndConditonsPage, workflowInfo.getTermsAndConditionsInfo());

        assertTrue(reviewPage.isMessageTextPresent(), "Review page not present!!!");

    }

    @DataProvider(name = "testData", parallel = false)
    public static Object[][] getTestData() {
        List<WorkflowInfo[]> workflows = new ArrayList<>();
        WorkflowEnums[] enums = WorkflowEnums.values();
        for (WorkflowEnums enum1 : enums) {
            WorkflowInfo[] workflowInfo = new WorkflowInfo[1];
            workflowInfo[0] = enum1.getData();
            workflows.add(workflowInfo);
        }

        return workflows.toArray(new WorkflowInfo[enums.length][]);
    }
}
