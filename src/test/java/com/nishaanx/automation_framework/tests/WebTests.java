package com.nishaanx.automation_framework.tests;

import com.nishaanx.automation_framework.base.Configurations;
import com.nishaanx.automation_framework.base.Res;
import com.nishaanx.automation_framework.data.WorkflowInfo;
import com.nishaanx.automation_framework.pages.web.BasePage;
import com.nishaanx.automation_framework.pages.web.CommunicationDetailsPage;
import com.nishaanx.automation_framework.pages.web.HomePage;
import com.nishaanx.automation_framework.pages.web.LoginPage;
import com.nishaanx.automation_framework.pages.web.MainAddressPage;
import com.nishaanx.automation_framework.pages.web.PaymentLandingPage;
import com.nishaanx.automation_framework.pages.web.PaymentPage;
import com.nishaanx.automation_framework.pages.web.PersonalDetailsPage;
import com.nishaanx.automation_framework.pages.web.ReviewPage;
import com.nishaanx.automation_framework.pages.web.TermsAndConditionsPage;
import com.nishaanx.automation_framework.pages.web.TrainingDetailsPage;
import com.nishaanx.automation_framework.utils.Excel;
import com.nishaanx.automation_framework.utils.ExcelContext;
import com.nishaanx.automation_framework.workflow.NishaanxWorkflowImpl;
import com.nishaanx.automation_framework.workflow.NishaanxWorkflows;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
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
        BasePage page = nw.fillValidationInformation(homePage, workflowInfo.getValidationInfo());

        PersonalDetailsPage personalDetailsPage = null;

        if (page instanceof LoginPage) {
            LoginPage loginPage = (LoginPage) page;
            assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is not loaded!!!");
            personalDetailsPage = nw.loginToTheSystem(loginPage, workflowInfo.getValidationInfo().getEmail(), "RCGP1234");
        } else {
            personalDetailsPage = (PersonalDetailsPage) page;
        }

        assertTrue(personalDetailsPage.isPersonalDetailsPagePresent(), "Person Details Page is not loaded!!!");
        CommunicationDetailsPage communicationsDetailsPage = nw.enterPersonalDetails(personalDetailsPage, workflowInfo.getPersonalDetailsInfo());

        assertTrue(communicationsDetailsPage.isCommunicationDetailsPagePresent(), "Communication Details Page is not loaded!!!");
        MainAddressPage mainAddressPage = nw.enterCommunicationDetails(communicationsDetailsPage, workflowInfo.getCommunicationDetailsInfo());

        assertTrue(mainAddressPage.isMainAddressPageLoad(), "Main Address Page is not loaded!!!");
        TrainingDetailsPage trainingDetailsPage = nw.enterMainAddressDetails(mainAddressPage, workflowInfo.getAddressDetailsInfo());

        assertTrue(trainingDetailsPage.isTrainingDetailsPagePresent(), "Training Details page is not present!!!");
        TermsAndConditionsPage termsAndConditonsPage = nw.enterTrainingDetails(trainingDetailsPage, workflowInfo.getTrainingDetailsInfo());

        assertTrue(termsAndConditonsPage.isTermsAndConditionsPagePresent(), "Terms and Conditions Page not present!!!");
        ReviewPage reviewPage = nw.acceptTermsAndConditions(termsAndConditonsPage, workflowInfo.getTermsAndConditionsInfo());

        assertTrue(reviewPage.isMessageTextPresent(), "Review page not present!!!");
        reviewPage = reviewPage.clickSubmit(ReviewPage.class);

        assertTrue(reviewPage.isNextStepButtonPresent(), "Review page not loaded!!!");
        PaymentLandingPage paymentLandingPage = reviewPage.clickNextStep();
        paymentLandingPage.handledSleep(20);

        assertTrue(paymentLandingPage.isNextStepButtonPresent(), "Payment Landing Page is not loaded!!!");
        PaymentPage paymentPage = paymentLandingPage.clickNextStep(PaymentPage.class);
        paymentPage.handledSleep(20);

        assertTrue(paymentPage.isPaymentPageDisplayed(), "Payment Page is not loaded!!!");
        paymentPage = nw.enterPaymentDetails(paymentPage, workflowInfo.getPaymentInfo());

        paymentPage.handledSleep(20);
    }

    @DataProvider(name = "testData", parallel = false)
    public static Object[][] getTestData() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, FileNotFoundException, NoSuchMethodException, URISyntaxException {
        ExcelContext context = new ExcelContext();
        Excel excel = new Excel(context);
        List<WorkflowInfo[]> workflows = new ArrayList<>();
        List<WorkflowInfo> workflowList = excel.getWorkflowData(Res.getResource("testData/Web.xlsx").toURI());
        for (WorkflowInfo workflow : workflowList) {
            WorkflowInfo[] workflowInfo = new WorkflowInfo[1];
            workflowInfo[0] = workflow;
            workflows.add(workflowInfo);
        }
        return workflows.subList(0, 1).toArray(new WorkflowInfo[1][]);
    }
}
