package com.nishaanx.automation_framework.workflow;

import com.nishaanx.automation_framework.data.CommunicationDetailsInfo;
import com.nishaanx.automation_framework.data.AddressDetailsInfo;
import com.nishaanx.automation_framework.data.PersonalDetailsInfo;
import com.nishaanx.automation_framework.data.TermsAndConditionsInfo;
import com.nishaanx.automation_framework.data.TrainingDetailsInfo;
import com.nishaanx.automation_framework.data.ValidationInfo;
import com.nishaanx.automation_framework.pages.web.CommunicationDetailsPage;
import com.nishaanx.automation_framework.pages.web.HomePage;
import com.nishaanx.automation_framework.pages.web.LoginPage;
import com.nishaanx.automation_framework.pages.web.MainAddressPage;
import com.nishaanx.automation_framework.pages.web.PersonalDetailsPage;
import com.nishaanx.automation_framework.pages.web.ReviewPage;
import com.nishaanx.automation_framework.pages.web.TermsAndConditionsPage;
import com.nishaanx.automation_framework.pages.web.TrainingDetailsPage;

public interface NishaanxWorkflows {

    public HomePage navigateToTheUrl(String url);

    public LoginPage fillValidationInformation(HomePage homePage, ValidationInfo validationInfo);

    public PersonalDetailsPage loginToTheSystem(LoginPage loginPage, String username, String password);

    public CommunicationDetailsPage enterPersonalDetails(PersonalDetailsPage personalDetailsPage, PersonalDetailsInfo personalDetailsInfo);

    public MainAddressPage enterCommunicationDetails(CommunicationDetailsPage communicationDetailsPage, CommunicationDetailsInfo communicationDetailsInfo);

    public TrainingDetailsPage enterMainAddressDetails(MainAddressPage mainAddressPage, AddressDetailsInfo mainAddressInfo);

    public TermsAndConditionsPage enterTrainingDetails(TrainingDetailsPage trainingDetailsPage, TrainingDetailsInfo trainingDetailsInfo);

    public ReviewPage acceptTermsAndConditions(TermsAndConditionsPage termsAndConditionsPage, TermsAndConditionsInfo termsAndConditionsInfo);

}
