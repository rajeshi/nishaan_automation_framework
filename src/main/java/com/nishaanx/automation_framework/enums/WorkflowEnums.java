package com.nishaanx.automation_framework.enums;

import com.nishaanx.automation_framework.data.AddressDetailsInfo;
import com.nishaanx.automation_framework.data.CommunicationDetailsInfo;
import com.nishaanx.automation_framework.data.PersonalDetailsInfo;
import com.nishaanx.automation_framework.data.TermsAndConditionsInfo;
import com.nishaanx.automation_framework.data.TrainingDetailsInfo;
import com.nishaanx.automation_framework.data.ValidationInfo;
import com.nishaanx.automation_framework.data.WorkflowInfo;

public enum WorkflowEnums implements Supplier<WorkflowInfo> {
    AIT_TYPE1_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();

            ValidationInfo validationInfo = new ValidationInfo();
            validationInfo.setGmcNumber("12345");
            validationInfo.setLastName("Knowles-Jarvis");
            validationInfo.setEmail("SebastianKnowles@dayrep.com");

            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            personalDetailsInfo.setTitle("Mr.");
            personalDetailsInfo.setForename("Sebastian");
            personalDetailsInfo.setLastname("Knowles");
            personalDetailsInfo.setDob("7/6/1997");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Male");

            CommunicationDetailsInfo communicationInfo = new CommunicationDetailsInfo();
            communicationInfo.setEmail("SebastianKnowles@dayrep.com");
            communicationInfo.setPhone("07819994850");

            AddressDetailsInfo addressDetailsInfo = new AddressDetailsInfo();
            addressDetailsInfo.setAddressLine("40 Cefn Road");
            addressDetailsInfo.setTownCity("Farningham");
            addressDetailsInfo.setPostCode("DA4 9XX");
            addressDetailsInfo.setCountry("United Kingdom");

            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            trainingDetailsInfo.setExpectedToFinish("12/31/2018");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("1234");
            trainingDetailsInfo.setWhichDeanery("London");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("OC - USA & Canada");
            trainingDetailsInfo.setTrainingPathWay("Full Time: Three Year Scheme");

            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setMainAddressInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            return workflowInfo;
        }

    },
    AIT_TYPE2_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();

            ValidationInfo validationInfo = new ValidationInfo();
            validationInfo.setGmcNumber("23456");
            validationInfo.setLastName("Vincent-Jarvis");
            validationInfo.setFirstName("Nicole");
            validationInfo.setEmail("NicoleVincent@einrot.com");

            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            personalDetailsInfo.setTitle("Dr.");
            personalDetailsInfo.setForename("Nicole");
            personalDetailsInfo.setLastname("Vincent");
            personalDetailsInfo.setDob("5/25/1998");
            personalDetailsInfo.setCountry("Brazil");
            personalDetailsInfo.setGender("Prefer not to say");

            CommunicationDetailsInfo communicationInfo = new CommunicationDetailsInfo();
            communicationInfo.setEmail("NicoleVincent@einrot.com");
            communicationInfo.setPhone("07969109157");

            AddressDetailsInfo addressDetailsInfo = new AddressDetailsInfo();
            addressDetailsInfo.setAddressLine("92 Fulford Road");
            addressDetailsInfo.setTownCity("Pentre-tafarn-y-fedw");
            addressDetailsInfo.setPostCode("LL26 9GZ");
            addressDetailsInfo.setCountry("United Kingdom");

            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            trainingDetailsInfo.setExpectedToFinish("6/30/2018");
            trainingDetailsInfo.setConductedInEnglish("No");
            trainingDetailsInfo.setNationalTrainingNumber("2345");
            trainingDetailsInfo.setWhichDeanery("Northern Ireland");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("OC - West Indies");
            trainingDetailsInfo.setTrainingPathWay("Full Time: Four Year Scheme");

            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            termsAndConditionsInfo.setOptinMemberDirectory(true);
            termsAndConditionsInfo.setNewsLetterCommunication(false);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setMainAddressInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            return workflowInfo;
        }
    },
    AIT_TYPE3_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();

            ValidationInfo validationInfo = new ValidationInfo();
            validationInfo.setGmcNumber("34567");
            validationInfo.setLastName("Hussain-Jarvis");
            validationInfo.setFirstName("Jamie");
            validationInfo.setEmail("JamieHussain@jourrapide.com");

            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            personalDetailsInfo.setTitle("Mr.");
            personalDetailsInfo.setForename("Jamie");
            personalDetailsInfo.setLastname("Hussain");
            personalDetailsInfo.setDob("2/8/1995");
            personalDetailsInfo.setCountry("Ukraine");
            personalDetailsInfo.setGender("Male");

            CommunicationDetailsInfo communicationInfo = new CommunicationDetailsInfo();
            communicationInfo.setEmail("JamieHussain@jourrapide.com");
            communicationInfo.setPhone("07869527260");

            AddressDetailsInfo addressDetailsInfo = new AddressDetailsInfo();
            addressDetailsInfo.setAddressLine("90 Crown Street");
            addressDetailsInfo.setTownCity("London");
            addressDetailsInfo.setPostCode("SW19 4AE");
            addressDetailsInfo.setCountry("United Kingdom");
            addressDetailsInfo.setIsCorrespondenceDifferent(true);
            addressDetailsInfo.setCorrespondenceAddressLine("123 Fake street");
            addressDetailsInfo.setCorrespondenceTownCity("Makebelieve land");
            addressDetailsInfo.setCorrespondencePostCode("FA12KE");
            addressDetailsInfo.setCorrespondenceCountry("Spain");


            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            trainingDetailsInfo.setExpectedToFinish("3/15/2019");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("3456");
            trainingDetailsInfo.setWhichDeanery("Oxford");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("OC - Zimbabwe");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 76% or More");

            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(false);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setMainAddressInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            return workflowInfo;
        }
    }

}
