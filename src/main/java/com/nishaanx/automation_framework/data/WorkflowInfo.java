package com.nishaanx.automation_framework.data;

public class WorkflowInfo {

    private ValidationInfo validationInfo;
    private PersonalDetailsInfo personalDetailsInfo;
    private CommunicationInfo communicationDetailsInfo;
    private AddressInfo addressDetailsInfo;
    private TrainingDetailsInfo trainingDetailsInfo;
    private TermsAndConditionsInfo termsAndConditionsInfo;
    private PaymentInfo paymentInfo;

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

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

    public CommunicationInfo getCommunicationDetailsInfo() {
        return communicationDetailsInfo;
    }

    public void setCommunicationDetailsInfo(CommunicationInfo communicationDetailsInfo) {
        this.communicationDetailsInfo = communicationDetailsInfo;
    }

    public AddressInfo getAddressDetailsInfo() {
        return addressDetailsInfo;
    }

    public void setAddressDetailsInfo(AddressInfo addressDetailsInfo) {
        this.addressDetailsInfo = addressDetailsInfo;
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
