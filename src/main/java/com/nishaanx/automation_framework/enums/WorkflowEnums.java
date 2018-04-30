package com.nishaanx.automation_framework.enums;

import com.nishaanx.automation_framework.data.AddressInfo;
import com.nishaanx.automation_framework.data.CommunicationInfo;
import com.nishaanx.automation_framework.data.PaymentInfo;
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
            personalDetailsInfo.setSurname("Knowles");
            personalDetailsInfo.setDob("7/6/1997");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Male");

            CommunicationInfo communicationInfo = new CommunicationInfo();
            communicationInfo.setEmail("SebastianKnowles@dayrep.com");
            communicationInfo.setPhone("07819994850");

            AddressInfo addressDetailsInfo = new AddressInfo();
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

            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setCardnumber("4111111111111111");
            paymentInfo.setCvvnumber("298");
            paymentInfo.setExpiryMonth("09");
            paymentInfo.setExpiryYear("2019");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
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
            personalDetailsInfo.setSurname("Vincent");
            personalDetailsInfo.setDob("5/25/1998");
            personalDetailsInfo.setCountry("Brazil");
            personalDetailsInfo.setGender("Prefer not to say");

            CommunicationInfo communicationInfo = new CommunicationInfo();
            communicationInfo.setEmail("NicoleVincent@einrot.com");
            communicationInfo.setPhone("07969109157");

            AddressInfo addressDetailsInfo = new AddressInfo();
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

            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setCardnumber("4111111111111111");
            paymentInfo.setCvvnumber("722");
            paymentInfo.setExpiryMonth("04");
            paymentInfo.setExpiryYear("2019");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    },
    AIT_TYPE3_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();

            ValidationInfo validationInfo = new ValidationInfo();
            validationInfo.setGmcNumber("45678");
            validationInfo.setLastName("Simmons-Jarvis");
            validationInfo.setFirstName("Leo");
            validationInfo.setEmail("LeoSimmons@teleworm.us");

            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            personalDetailsInfo.setTitle("Dr.");
            personalDetailsInfo.setForename("Leo");
            personalDetailsInfo.setSurname("Simmons");
            personalDetailsInfo.setDob("17/12/2000");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Prefer not to say");

            CommunicationInfo communicationInfo = new CommunicationInfo();
            communicationInfo.setEmail("LeoSimmons@teleworm.us");
            communicationInfo.setPhone("07034756031");

            AddressInfo addressDetailsInfo = new AddressInfo();
            addressDetailsInfo.setAddressLine("23 Botley Road");
            addressDetailsInfo.setTownCity("Middleton green");
            addressDetailsInfo.setPostCode("ST10 0GE");
            addressDetailsInfo.setCountry("United Kingdom");
            addressDetailsInfo.setIsCorrespondenceDifferent(false);
            addressDetailsInfo.setCorrespondenceAddressLine("123 Fake street");
            addressDetailsInfo.setCorrespondenceTownCity("Makebelieve land");
            addressDetailsInfo.setCorrespondencePostCode("FA12KE");
            addressDetailsInfo.setCorrespondenceCountry("Spain");

            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            trainingDetailsInfo.setExpectedToFinish("10/8/2018");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("4567");
            trainingDetailsInfo.setWhichDeanery("Severn");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Aberdeen");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 75% or Less");

            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setCardnumber("4111111111111111");
            paymentInfo.setCvvnumber("289");
            paymentInfo.setExpiryMonth("01");
            paymentInfo.setExpiryYear("2020");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressDetailsInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    }, AIT_TYPE4_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("56789");
            validationInfo.setLastName("Dean-Jarvis");
            validationInfo.setEmail("IsobelDean@einrot.com");
            validationInfo.setFirstName("Isobel");

            personalDetailsInfo.setTitle("Mrs.");
            personalDetailsInfo.setForename("Isobel");
            personalDetailsInfo.setSurname("Dean");
            personalDetailsInfo.setDob("22/10/1996");
            personalDetailsInfo.setCountry("India");
            personalDetailsInfo.setGender("Female");

            communicationInfo.setEmail("IsobelDean@einrot.com");
            communicationInfo.setPhone("077 7665 7192");

            addressInfo.setAddressLine("52 Fox Lane");
            addressInfo.setTownCity("Bocking churchstreet");
            addressInfo.setPostCode("CM7 4WL");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(false);

            trainingDetailsInfo.setExpectedToFinish("18/1/2019");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("5678");
            trainingDetailsInfo.setWhichDeanery("South East Scotland");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Belfast - Queen's University");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 76% or More");

            termsAndConditionsInfo.setOptinMemberDirectory(true);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("2");
            paymentInfo.setExpiryYear("2020");
            paymentInfo.setCvvnumber("520");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    }, AIT_TYPE5_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("54321");
            validationInfo.setLastName("Walker-Jarvis");
            validationInfo.setEmail("BradleyWalker@einrot.com");
            validationInfo.setFirstName("Bradley");

            personalDetailsInfo.setTitle("Mr.");
            personalDetailsInfo.setForename("Bradley");
            personalDetailsInfo.setSurname("Walker");
            personalDetailsInfo.setDob("4/7/1999");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Male");

            communicationInfo.setEmail("BradleyWalker@einrot.com");
            communicationInfo.setPhone("070 3603 5566");

            addressInfo.setAddressLine("81 Vicar Lane");
            addressInfo.setTownCity("SANDTOFT");
            addressInfo.setPostCode("DN8 4BN");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(false);
            addressInfo.setCorrespondenceAddressLine("");
            addressInfo.setCorrespondenceTownCity("");
            addressInfo.setCorrespondencePostCode("");
            addressInfo.setCorrespondenceCountry("");

            trainingDetailsInfo.setExpectedToFinish("5/12/2020");
            trainingDetailsInfo.setConductedInEnglish("No");
            trainingDetailsInfo.setNationalTrainingNumber("6789");
            trainingDetailsInfo.setWhichDeanery("South West Peninsula");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Brighton and Sussex");
            trainingDetailsInfo.setTrainingPathWay("Full Time: Three Year Scheme");

            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("12");
            paymentInfo.setExpiryYear("2022");
            paymentInfo.setCvvnumber("846");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
            /*},
    AIT_TYPE6_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("65432");
            validationInfo.setLastName("Robinson-Jarvis");
            validationInfo.setEmail("NaomiRobinson@rhyta.com");
            validationInfo.setFirstName("Naomi");

            personalDetailsInfo.setTitle("Ms.");
            personalDetailsInfo.setForename("Naomi");
            personalDetailsInfo.setSurname("Robinson");
            personalDetailsInfo.setDob("24/4/2001");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Female");

            communicationInfo.setEmail("NaomiRobinson@rhyta.com");
            communicationInfo.setPhone("070 8615 8969");

            addressInfo.setAddressLine("30 Winchester Rd");
            addressInfo.setTownCity("MERTON");
            addressInfo.setPostCode("OX6 9YW");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(true);
            addressInfo.setCorrespondenceAddressLine("1 Street name");
            addressInfo.setCorrespondenceTownCity("Inatown");
            addressInfo.setCorrespondencePostCode("Te57st");
            addressInfo.setCorrespondenceCountry("France");

            trainingDetailsInfo.setExpectedToFinish("29/3/2021");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("7890");
            trainingDetailsInfo.setWhichDeanery("East Midlands");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Bristol");
            trainingDetailsInfo.setTrainingPathWay("Full Time: Four Year Scheme");

            termsAndConditionsInfo.setOptinMemberDirectory(true);
            termsAndConditionsInfo.setNewsLetterCommunication(false);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("10");
            paymentInfo.setExpiryYear("2021");
            paymentInfo.setCvvnumber("972");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    }, AIT_TYPE7_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("76543");
            validationInfo.setLastName("Lucas-Jarvis");
            validationInfo.setEmail("JodieLucas@dayrep.com");
            validationInfo.setFirstName("Jodie");

            personalDetailsInfo.setTitle("Ms.");
            personalDetailsInfo.setForename("Jodie");
            personalDetailsInfo.setSurname("Lucas");
            personalDetailsInfo.setDob("22/2/1997");
            personalDetailsInfo.setCountry("South Africa");
            personalDetailsInfo.setGender("Female");

            communicationInfo.setEmail("JodieLucas@dayrep.com");
            communicationInfo.setPhone("079 6586 1748");

            addressInfo.setAddressLine("17 Academy Street");
            addressInfo.setTownCity("BENTLEY");
            addressInfo.setPostCode("HU17 3XS");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(false);
            addressInfo.setCorrespondenceAddressLine("");
            addressInfo.setCorrespondenceTownCity("");
            addressInfo.setCorrespondencePostCode("");
            addressInfo.setCorrespondenceCountry("");

            trainingDetailsInfo.setExpectedToFinish("11/12/2022");
            trainingDetailsInfo.setConductedInEnglish("No");
            trainingDetailsInfo.setNationalTrainingNumber("9876");
            trainingDetailsInfo.setWhichDeanery("Yorkshire & Humber");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Cambridge");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 76% or More");

            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(false);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("11");
            paymentInfo.setExpiryYear("2019");
            paymentInfo.setCvvnumber("316");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    }, AIT_TYPE8_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("87654");
            validationInfo.setLastName("Adams-Jarvis");
            validationInfo.setEmail("LoganAdams@cuvox.de");
            validationInfo.setFirstName("Logan");

            personalDetailsInfo.setTitle("Mr.");
            personalDetailsInfo.setForename("Logan");
            personalDetailsInfo.setSurname("Adams");
            personalDetailsInfo.setDob("13/8/1998");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Prefer not to say");

            communicationInfo.setEmail("LoganAdams@cuvox.de");
            communicationInfo.setPhone("077 4308 6488");

            addressInfo.setAddressLine("36 St James Boulevard");
            addressInfo.setTownCity("HORTON");
            addressInfo.setPostCode("LU7 5XA");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(false);
            addressInfo.setCorrespondenceAddressLine("");
            addressInfo.setCorrespondenceTownCity("");
            addressInfo.setCorrespondencePostCode("");
            addressInfo.setCorrespondenceCountry("");

            trainingDetailsInfo.setExpectedToFinish("31/8/2019");
            trainingDetailsInfo.setConductedInEnglish("No");
            trainingDetailsInfo.setNationalTrainingNumber("8765");
            trainingDetailsInfo.setWhichDeanery("Wales");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Wales (inc Cardiff & Swansea)");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 75% or Less");

            termsAndConditionsInfo.setOptinMemberDirectory(false);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("7");
            paymentInfo.setExpiryYear("2023");
            paymentInfo.setCvvnumber("542");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }
    }, AIT_TYPE9_WORKFLOW {
        @Override
        public WorkflowInfo getData() {
            WorkflowInfo workflowInfo = new WorkflowInfo();
            ValidationInfo validationInfo = new ValidationInfo();
            PersonalDetailsInfo personalDetailsInfo = new PersonalDetailsInfo();
            CommunicationInfo communicationInfo = new CommunicationInfo();
            AddressInfo addressInfo = new AddressInfo();
            TrainingDetailsInfo trainingDetailsInfo = new TrainingDetailsInfo();
            TermsAndConditionsInfo termsAndConditionsInfo = new TermsAndConditionsInfo();
            PaymentInfo paymentInfo = new PaymentInfo();

            validationInfo.setGmcNumber("98765");
            validationInfo.setLastName("Clements-Jarvis");
            validationInfo.setEmail("JenniferClements@dayrep.com");
            validationInfo.setFirstName("Jennifer");

            personalDetailsInfo.setTitle("Ms.");
            personalDetailsInfo.setForename("Jennifer");
            personalDetailsInfo.setSurname("Clements");
            personalDetailsInfo.setDob("8/6/1999");
            personalDetailsInfo.setCountry("United Kingdom");
            personalDetailsInfo.setGender("Female");

            communicationInfo.setEmail("JenniferClements@dayrep.com");
            communicationInfo.setPhone("079 4320 0779");

            addressInfo.setAddressLine("69 Rhosddu Rd");
            addressInfo.setTownCity("FIFE KEITH");
            addressInfo.setPostCode("AB55 9NQ");
            addressInfo.setCountry("United Kingdom");
            addressInfo.setIsCorrespondenceDifferent(false);
            addressInfo.setCorrespondenceAddressLine("");
            addressInfo.setCorrespondenceTownCity("");
            addressInfo.setCorrespondencePostCode("");
            addressInfo.setCorrespondenceCountry("");

            trainingDetailsInfo.setExpectedToFinish("28/2/2021");
            trainingDetailsInfo.setConductedInEnglish("Yes");
            trainingDetailsInfo.setNationalTrainingNumber("7654");
            trainingDetailsInfo.setWhichDeanery("Wessex");
            trainingDetailsInfo.setMedicalSchoolUkOrOtherCountry("UK - Dundee");
            trainingDetailsInfo.setTrainingPathWay("Less Than Full Time: 76% or More");

            termsAndConditionsInfo.setOptinMemberDirectory(true);
            termsAndConditionsInfo.setNewsLetterCommunication(true);
            termsAndConditionsInfo.setAgreeTermsAndConditions(true);

            paymentInfo.setCardnumber("4111111111111110");
            paymentInfo.setExpiryMonth("6");
            paymentInfo.setExpiryYear("2022");
            paymentInfo.setCvvnumber("629");

            workflowInfo.setValidationInfo(validationInfo);
            workflowInfo.setPersonalDetailsInfo(personalDetailsInfo);
            workflowInfo.setCommunicationDetailsInfo(communicationInfo);
            workflowInfo.setAddressDetailsInfo(addressInfo);
            workflowInfo.setTrainingDetailsInfo(trainingDetailsInfo);
            workflowInfo.setTermsAndConditionsInfo(termsAndConditionsInfo);
            workflowInfo.setPaymentInfo(paymentInfo);
            return workflowInfo;
        }*/
    }
}
