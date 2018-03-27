package com.nishaanx.automation_framework.workflow;

import com.nishaanx.automation_framework.base.DriverFactory;
import com.nishaanx.automation_framework.data.AddressDetailsInfo;
import com.nishaanx.automation_framework.data.CommunicationDetailsInfo;
import com.nishaanx.automation_framework.data.PaymentInfo;
import com.nishaanx.automation_framework.data.PersonalDetailsInfo;
import com.nishaanx.automation_framework.data.TermsAndConditionsInfo;
import com.nishaanx.automation_framework.data.TrainingDetailsInfo;
import com.nishaanx.automation_framework.data.ValidationInfo;
import com.nishaanx.automation_framework.pages.web.CommunicationDetailsPage;
import com.nishaanx.automation_framework.pages.web.HomePage;
import com.nishaanx.automation_framework.pages.web.LoginPage;
import com.nishaanx.automation_framework.pages.web.MainAddressPage;
import com.nishaanx.automation_framework.pages.web.PaymentPage;
import com.nishaanx.automation_framework.pages.web.PersonalDetailsPage;
import com.nishaanx.automation_framework.pages.web.ReviewPage;
import com.nishaanx.automation_framework.pages.web.TermsAndConditionsPage;
import com.nishaanx.automation_framework.pages.web.TrainingDetailsPage;

public class NishaanxWorkflowImpl implements NishaanxWorkflows {

    @Override
    public HomePage navigateToTheUrl(String url) {
        DriverFactory.getDriver().get(url);
        return new HomePage();
    }

    @Override
    public LoginPage fillValidationInformation(HomePage homePage, ValidationInfo validationInfo) {
        homePage = homePage.enterGmcNumber(validationInfo.getGmcNumber())
                .enterLastName(validationInfo.getLastName())
                .enterEmail(validationInfo.getEmail());

        if (homePage.IsValidateButtonDisabled()) {
            throw new AssertionError("Validate Button should be enabled");
        }
        homePage = homePage.clickValidate(HomePage.class);
        if (homePage.isContinueButtonDisplayed()) {
            return (LoginPage) homePage.clickContinue(LoginPage.class);
        }
        throw new AssertionError("Continue Button is not displayed/present");
    }

    @Override
    public PersonalDetailsPage loginToTheSystem(LoginPage loginPage, String username, String password) {
        return loginPage.enterUserName(username)
                .enterPassword(password)
                .clickSubmit(PersonalDetailsPage.class);
    }

    @Override
    public CommunicationDetailsPage enterPersonalDetails(PersonalDetailsPage personalDetailsPage, PersonalDetailsInfo personalDetailsInfo) {
        return personalDetailsPage.selectTitle(personalDetailsInfo.getTitle())
                .enterForename(personalDetailsInfo.getForename())
                .enterSurname(personalDetailsInfo.getLastname())
                .enterDob(personalDetailsInfo.getDob())
                .selectCountryOfBirth(personalDetailsInfo.getCountry())
                .selectGender(personalDetailsInfo.getGender())
                .clickNext(CommunicationDetailsPage.class);
    }

    @Override
    public MainAddressPage enterCommunicationDetails(CommunicationDetailsPage communicationDetailsPage, CommunicationDetailsInfo communicationDetailsInfo) {
        return communicationDetailsPage.enterEmail(communicationDetailsInfo.getEmail())
                .enterPhone(communicationDetailsInfo.getPhone())
                .clickNext(MainAddressPage.class);
    }

    @Override
    public TrainingDetailsPage enterMainAddressDetails(MainAddressPage mainAddressPage, AddressDetailsInfo mainAddressInfo) {
        mainAddressPage = mainAddressPage.enterMainAddressLine(mainAddressInfo.getAddressLine())
                .enterMainAddressTownCity(mainAddressInfo.getTownCity())
                .enterMainAddressPostcode(mainAddressInfo.getPostCode())
                .selectMainAddressCountry(mainAddressInfo.getCountry())
                .checkisCorrespondenceAddress(mainAddressInfo.isIsCorrespondenceDifferent());
        if (mainAddressInfo.isIsCorrespondenceDifferent()) {
            mainAddressPage.enterCorrespondenceAddressLine(mainAddressInfo.getCorrespondenceAddressLine())
                    .enterCorrespondenceTownCity(mainAddressInfo.getCorrespondenceTownCity())
                    .enterCorrespondencePostcode(mainAddressInfo.getCorrespondencePostCode())
                    .selectCorrespondenceCountry(mainAddressInfo.getCorrespondenceCountry());
        }
        return mainAddressPage.clickNext(TrainingDetailsPage.class);
    }

    @Override
    public TermsAndConditionsPage enterTrainingDetails(TrainingDetailsPage trainingDetailsPage, TrainingDetailsInfo trainingDetailsInfo) {
        return trainingDetailsPage.selectWhatTrainingPathway(trainingDetailsInfo.getTrainingPathWay())
                .selectUkMedicalSchool(trainingDetailsInfo.getMedicalSchoolUkOrOtherCountry())
                .selectUndergraduateConductedInEnglish(trainingDetailsInfo.getConductedInEnglish())
                .selectWhichDeaneryTraining(trainingDetailsInfo.getWhichDeanery())
                .enterNationalTrainingNumber(trainingDetailsInfo.getNationalTrainingNumber())
                .enterWhenToExpectFinish(trainingDetailsInfo.getExpectedToFinish())
                .clickNext(TermsAndConditionsPage.class);
    }

    @Override
    public ReviewPage acceptTermsAndConditions(TermsAndConditionsPage termsAndConditionsPage, TermsAndConditionsInfo termsAndConditionsInfo) {
        return termsAndConditionsPage.checkRcgpMemberDirectoryCheckBox(termsAndConditionsInfo.getNewsLetterCommunication())
                .checkOptinForNewsletterFromRcgp(termsAndConditionsInfo.getOptinMemberDirectory())
                .checkAgreeToTermsAndConditions(termsAndConditionsInfo.getAgreeTermsAndConditions())
                .clickNext(ReviewPage.class);
    }

    @Override
    public PaymentPage enterPaymentDetails(PaymentPage paymentPage, PaymentInfo paymentInfo) {
        return paymentPage.enterCardNumber(paymentInfo.getCardnumber())
                .enterMonth(paymentInfo.getExpiryMonth())
                .enterYear(paymentInfo.getExpiryYear())
                .enterCvv(paymentInfo.getCvvnumber())
                .clickSubmit(PaymentPage.class);
    }
}
