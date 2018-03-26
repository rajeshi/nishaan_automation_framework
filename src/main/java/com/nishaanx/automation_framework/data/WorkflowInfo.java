package com.nishaanx.automation_framework.data;

public class WorkflowInfo {

    private ValidationInfo validationInfo;
    private PersonalDetailsInfo personalDetailsInfo;
    private CommunicationDetailsInfo communicationDetailsInfo;
    private AddressDetailsInfo mainAddressInfo;
    private TrainingDetailsInfo trainingDetailsInfo;
    private TermsAndConditionsInfo termsAndConditionsInfo;

    public ValidationInfo getValidationInfo() {
        return validationInfo;
    }

    public void setValidationInfo(ValidationInfo validationInfo) {
        this.validationInfo = validationInfo;
    }

    public PersonalDetailsInfo getPersonalDetailsInfo() {
        return personalDetailsInfo;
    }

    public void setPersonalDetailsInfo(PersonalDetailsInfo personalDetailsInfo) {
        this.personalDetailsInfo = personalDetailsInfo;
    }

    public CommunicationDetailsInfo getCommunicationDetailsInfo() {
        return communicationDetailsInfo;
    }

    public void setCommunicationDetailsInfo(CommunicationDetailsInfo communicationDetailsInfo) {
        this.communicationDetailsInfo = communicationDetailsInfo;
    }

    public AddressDetailsInfo getMainAddressInfo() {
        return mainAddressInfo;
    }

    public void setMainAddressInfo(AddressDetailsInfo mainAddressInfo) {
        this.mainAddressInfo = mainAddressInfo;
    }

    public TrainingDetailsInfo getTrainingDetailsInfo() {
        return trainingDetailsInfo;
    }

    public void setTrainingDetailsInfo(TrainingDetailsInfo trainingDetailsInfo) {
        this.trainingDetailsInfo = trainingDetailsInfo;
    }

    public TermsAndConditionsInfo getTermsAndConditionsInfo() {
        return termsAndConditionsInfo;
    }

    public void setTermsAndConditionsInfo(TermsAndConditionsInfo termsAndConditionsInfo) {
        this.termsAndConditionsInfo = termsAndConditionsInfo;
    }

}
