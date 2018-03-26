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
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("OC - USA &amp; Canada");
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

    }
}
