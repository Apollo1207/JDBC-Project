package org.example.project.jdbc.view;

import org.example.project.jdbc.controller.implementation.*;
import org.example.project.jdbc.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class MainView {

    private final InjuryOnCallController injuryOnCallController = new InjuryOnCallController();
    private final RescuerOfCrewController rescuerOfCrewController = new RescuerOfCrewController();
    private final CrewAcceptedHasRescuerOfCrewController crewAcceptedHasRescuerOfCrewController = new CrewAcceptedHasRescuerOfCrewController();
    private final CrewAcceptedController crewAcceptedController = new CrewAcceptedController();
    private final ReceivedCallHasCrewAcceptedController receivedCallHasCrewAcceptedController = new ReceivedCallHasCrewAcceptedController();
    private final EmergencyDetailsController emergencyDetailsController = new EmergencyDetailsController();
    private final DescriptionController descriptionController = new DescriptionController();
    private final PersonInformationReportController personInformationReportController = new PersonInformationReportController();
    private final ReceivedCallController receivedCallController = new ReceivedCallController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all injuryOnCalls");
        menu.put("12", "12 - Get injuryOnCall by ID");
        menu.put("13", "13 - Create injuryOnCall");
        menu.put("14", "14 - Delete injuryOnCall by ID");
        menu.put("15", "15 - Update injuryOnCall by ID");

        menu.put("21", "21 - Get all rescuerOfCrews");
        menu.put("22", "22 - Get rescuerOfCrew by ID");
        menu.put("23", "23 - Create rescuerOfCrew");
        menu.put("24", "24 - Delete rescuerOfCrew by ID");
        menu.put("25", "25 - Update rescuerOfCrew by ID");

        menu.put("31", "31 - Get all crewAcceptedHasRescuerOfCrews");
        menu.put("32", "32 - Get crewAcceptedHasRescuerOfCrew by id");
        menu.put("33", "33 - Create crewAcceptedHasRescuerOfCrew");
        menu.put("34", "34 - Delete crewAcceptedHasRescuerOfCrew by ID");
        menu.put("35", "35 - Update crewAcceptedHasRescuerOfCrew");

        menu.put("41", "41 - Get all crewAccepteds");
        menu.put("42", "42 - Get crewAccepted by ID");
        menu.put("43", "43 - Create crewAccepted");
        menu.put("44", "44 - Delete crewAccepted by ID");
        menu.put("45", "45 - Update crewAccepted by ID");

        menu.put("51", "51 - Get all receivedCallHasCrewAccepteds");
        menu.put("52", "52 - Get receivedCallHasCrewAccepted by ID");
        menu.put("53", "53 - Create receivedCallHasCrewAccepted");
        menu.put("54", "54 - Delete receivedCallHasCrewAccepted by ID");
        menu.put("55", "55 - Update receivedCallHasCrewAccepted by ID");

        menu.put("61", "61 - Get all emergencyDetailss");
        menu.put("62", "62 - Get emergencyDetails by ID");
        menu.put("63", "63 - Create emergencyDetails");
        menu.put("64", "64 - Delete emergencyDetails by ID");
        menu.put("65", "65 - Update emergencyDetails by ID");

        menu.put("71", "71 - Get all descriptions");
        menu.put("72", "72 - Get description by ID");
        menu.put("73", "73 - Create description");
        menu.put("74", "74 - Delete description by ID");
        menu.put("75", "75 - Update description by ID");

        menu.put("81", "81 - Get all personInformationReports");
        menu.put("82", "82 - Get personInformationReport by ID");
        menu.put("83", "83 - Create personInformationReport");
        menu.put("84", "84 - Delete personInformationReport by ID");
        menu.put("85", "85 - Update personInformationReport by ID");

        menu.put("91", "91 - Get all receivedCalls");
        menu.put("92", "92 - Get receivedCall by ID");
        menu.put("93", "93 - Create receivedCall");
        menu.put("94", "94 - Delete receivedCall by ID");
        menu.put("95", "95 - Update receivedCall by ID");


        methodsMenu.put("11", this::getAllInjuryOnCalls);
        methodsMenu.put("12", this::getInjuryOnCallById);
        methodsMenu.put("13", this::createInjuryOnCall);
        methodsMenu.put("14", this::deleteInjuryOnCallById);
        methodsMenu.put("15", this::updateInjuryOnCallById);

        methodsMenu.put("21", this::getAllRescuerOfCrews);
        methodsMenu.put("22", this::getRescuerOfCrewById);
        methodsMenu.put("23", this::createRescuerOfCrew);
        methodsMenu.put("24", this::deleteRescuerOfCrewById);
        methodsMenu.put("25", this::updateRescuerOfCrewById);

        methodsMenu.put("31", this::getAllCrewAcceptedHasRescuerOfCrews);
        methodsMenu.put("32", this::getCrewAcceptedHasRescuerOfCrewById);
        methodsMenu.put("33", this::createCrewAcceptedHasRescuerOfCrew);
        methodsMenu.put("34", this::deleteCrewAcceptedHasRescuerOfCrewById);
        methodsMenu.put("35", this::updateCrewAcceptedHasRescuerOfCrewById);

        methodsMenu.put("41", this::getAllCrewAccepteds);
        methodsMenu.put("42", this::getCrewAcceptedById);
        methodsMenu.put("43", this::createCrewAccepted);
        methodsMenu.put("44", this::deleteCrewAcceptedById);
        methodsMenu.put("45", this::updateCrewAcceptedById);

        methodsMenu.put("51", this::getAllReceivedCallHasCrewAccepteds);
        methodsMenu.put("52", this::getReceivedCallHasCrewAcceptedById);
        methodsMenu.put("53", this::createReceivedCallHasCrewAccepted);
        methodsMenu.put("54", this::deleteReceivedCallHasCrewAcceptedById);
        methodsMenu.put("55", this::updateReceivedCallHasCrewAcceptedById);

        methodsMenu.put("61", this::getAllEmergencyDetailss);
        methodsMenu.put("62", this::getEmergencyDetailsById);
        methodsMenu.put("63", this::createEmergencyDetails);
        methodsMenu.put("64", this::deleteEmergencyDetailsById);
        methodsMenu.put("65", this::updateEmergencyDetailsById);

        methodsMenu.put("71", this::getAllDescriptions);
        methodsMenu.put("72", this::getDescriptionById);
        methodsMenu.put("73", this::createDescription);
        methodsMenu.put("74", this::deleteDescriptionById);
        methodsMenu.put("75", this::updateDescriptionById);

        methodsMenu.put("81", this::getAllPersonInformationReports);
        methodsMenu.put("82", this::getPersonInformationReportById);
        methodsMenu.put("83", this::createPersonInformationReport);
        methodsMenu.put("84", this::deletePersonInformationReportById);
        methodsMenu.put("85", this::updatePersonInformationReportById);

        methodsMenu.put("91", this::getAllReceivedCalls);
        methodsMenu.put("92", this::getReceivedCallById);
        methodsMenu.put("93", this::createReceivedCall);
        methodsMenu.put("94", this::deleteReceivedCallById);
        methodsMenu.put("95", this::updateReceivedCallById);
    }

    private void getAllInjuryOnCalls() throws SQLException {
        System.out.println("\nTable: InjuryOnCall");
        injuryOnCallController.getAll();
    }

    private void getInjuryOnCallById() throws SQLException {
        System.out.println("Enter ID for InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        injuryOnCallController.getById(id);
    }

    private void createInjuryOnCall() throws SQLException {
        System.out.println("Enter new InjuryOnCall name of injury: ");
        String nameOfInjury = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall description of injury: ");
        String descriptionOfInjury = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall number of hospital: ");
        String numberOfHospital = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall diagnosis: ");
        String diagnosis = INPUT.nextLine();
        InjuryOnCall entity = new InjuryOnCall(0, nameOfInjury, descriptionOfInjury, numberOfHospital, diagnosis);
        injuryOnCallController.create(entity);
    }

    private void deleteInjuryOnCallById() throws SQLException {
        System.out.println("Enter ID to delete InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        injuryOnCallController.delete(id);
    }

    private void updateInjuryOnCallById() throws SQLException {
        System.out.println("Enter InjuryOnCall id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        InjuryOnCall oldInjuryOnCall = injuryOnCallController.getService().getById(id);
        System.out.println("Enter new name of injury for InjuryOnCall: ");
        String nameOfInjury = INPUT.nextLine();
        System.out.println("Enter new description of injury for InjuryOnCall: ");
        String descriptionOfInjury = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall number of hospital: ");
        String numberOfHospital = INPUT.nextLine();
        System.out.println("Enter new diagnosis for InjuryOnCall: ");
        String diagnosis = INPUT.nextLine();

        String newNameOfInjury = nameOfInjury;
        String newDescriptionOfInjury = descriptionOfInjury;
        String newNumberOfHospital = numberOfHospital;
        String newDiagnosis = diagnosis;


        if (nameOfInjury.equals("")) newNameOfInjury = oldInjuryOnCall.getNameOfInjury();
        if (descriptionOfInjury.equals("")) newDescriptionOfInjury = oldInjuryOnCall.getDescriptionOfInjury();
        if (numberOfHospital.equals("")) newNumberOfHospital = oldInjuryOnCall.getNumberOfHospital();
        if (diagnosis.equals("")) newDiagnosis = oldInjuryOnCall.getDiagnosis();

        InjuryOnCall entity = new InjuryOnCall(id, newNameOfInjury, newDescriptionOfInjury, newNumberOfHospital, newDiagnosis);
        injuryOnCallController.update(entity);
    }


    private void getAllRescuerOfCrews() throws SQLException {
        System.out.println("\nTable: RescuerOfCrew");
        rescuerOfCrewController.getAll();
    }

    private void getRescuerOfCrewById() throws SQLException {
        System.out.println("Enter ID for RescuerOfCrew: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        rescuerOfCrewController.getById(id);
    }

    private void createRescuerOfCrew() throws SQLException {
        System.out.println("Enter new RescuerOfCrew name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew sur name: ");
        String surName = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew number of token :");
        int numberOfToken = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew rank position: ");
        String rankPosition = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew date of birth: ");
        String dateOfBirth = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew address of residence: ");
        String addressOfResidence = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew injury on call id: ");
        int injuryOnCallId = INPUT.nextInt();
        INPUT.nextLine();
        RescuerOfCrew entity = new RescuerOfCrew(0, name, lastName, surName, numberOfToken, rankPosition, dateOfBirth, addressOfResidence, injuryOnCallId);
        rescuerOfCrewController.create(entity);
    }

    private void deleteRescuerOfCrewById() throws SQLException {
        System.out.println("Enter ID to delete RescuerOfCrew: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        rescuerOfCrewController.delete(id);
    }

    private void updateRescuerOfCrewById() throws SQLException {
        System.out.println("Enter RescuerOfCrew id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        RescuerOfCrew oldRescuerOfCrew = rescuerOfCrewController.getService().getById(id);

        System.out.println("Enter new RescuerOfCrew name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew sur name: ");
        String surName = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew number of token :");
        int numberOfToken = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew rank position: ");
        String rankPosition = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew date of birth: ");
        String dateOfBirth = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew address of residence: ");
        String addressOfResidence = INPUT.nextLine();
        System.out.println("Enter new RescuerOfCrew injury on call id: ");
        int injuryOnCallId = INPUT.nextInt();
        INPUT.nextLine();

        String newName = name;
        String newLastName = lastName;
        String newSurName = surName;
        Integer newNumberOfToken = numberOfToken;
        String newRankPosition = rankPosition;
        String newDateOfBirth = dateOfBirth;
        String newAddressOfResidence = addressOfResidence;
        Integer newInjuryOnCallId = injuryOnCallId;


        if (name.equals("")) newName = oldRescuerOfCrew.getName();
        if (lastName.equals("")) newLastName = oldRescuerOfCrew.getLastName();
        if (surName.equals("")) newSurName = oldRescuerOfCrew.getSurName();
        if (numberOfToken < 0) newNumberOfToken = oldRescuerOfCrew.getNumberOfToken();
        if (rankPosition.equals("")) newRankPosition = oldRescuerOfCrew.getRankPosition();
        if (dateOfBirth.equals("")) newDateOfBirth = oldRescuerOfCrew.getDateOfBirth();
        if (addressOfResidence.equals("")) newAddressOfResidence = oldRescuerOfCrew.getAddressOfResidence();
        if (injuryOnCallId < 0) newInjuryOnCallId = oldRescuerOfCrew.getInjuryOnCallId();


        RescuerOfCrew entity = new RescuerOfCrew(id, newName, newLastName, newSurName, newNumberOfToken, newRankPosition, newDateOfBirth, newAddressOfResidence, newInjuryOnCallId);
        rescuerOfCrewController.update(entity);
    }


    private void getAllCrewAcceptedHasRescuerOfCrews() throws SQLException {
        System.out.println("\nTable: CrewAcceptedHasRescuerOfCrew");
        crewAcceptedHasRescuerOfCrewController.getAll();
    }

    private void getCrewAcceptedHasRescuerOfCrewById() throws SQLException {
        System.out.println("Enter crewAcceptedId for CrewAcceptedHasRescuerOfCrew: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedHasRescuerOfCrewController.getById(id);
    }

    private void createCrewAcceptedHasRescuerOfCrew() throws SQLException {

        System.out.println("Enter new CrewAcceptedHasRescuerOfCrew crew accepted id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new CrewAcceptedHasRescuerOfCrew rescuer of crew id: ");
        int rescuerOfCrewId = INPUT.nextInt();
        INPUT.nextLine();

        CrewAcceptedHasRescuerOfCrew entity = new CrewAcceptedHasRescuerOfCrew(crewAcceptedId, rescuerOfCrewId);
        crewAcceptedHasRescuerOfCrewController.create(entity);
    }

    private void deleteCrewAcceptedHasRescuerOfCrewById() throws SQLException {
        System.out.println("Enter ID to delete CrewAcceptedHasRescuerOfCrew: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedHasRescuerOfCrewController.delete(id);
    }

    private void updateCrewAcceptedHasRescuerOfCrewById() throws SQLException {

        System.out.println("Enter CrewAcceptedHasRescuerOfCrew id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        CrewAcceptedHasRescuerOfCrew oldCrewAcceptedHasRescuerOfCrew = crewAcceptedHasRescuerOfCrewController.getService().getById(id);


        System.out.println("Enter new CrewAcceptedHasRescuerOfCrew crew accepted id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new CrewAcceptedHasRescuerOfCrew rescuer of crew id: ");
        int rescuerOfCrewId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newCrewAcceptedId = crewAcceptedId;
        Integer newRescuerOfCrewId = rescuerOfCrewId;


        if (crewAcceptedId < 0) newCrewAcceptedId = oldCrewAcceptedHasRescuerOfCrew.getCrewAcceptedId();
        if (rescuerOfCrewId < 0) newRescuerOfCrewId = oldCrewAcceptedHasRescuerOfCrew.getRescuerOfCrewId();


        CrewAcceptedHasRescuerOfCrew entity = new CrewAcceptedHasRescuerOfCrew(newCrewAcceptedId, newRescuerOfCrewId);
        crewAcceptedHasRescuerOfCrewController.update(entity);
    }

    private void getAllCrewAccepteds() throws SQLException {
        System.out.println("\nTable: CrewAccepted");
        crewAcceptedController.getAll();
    }

    private void getCrewAcceptedById() throws SQLException {
        System.out.println("Enter ID for CrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedController.getById(id);
    }

    private void createCrewAccepted() throws SQLException {
        System.out.println("Enter new CrewAccepted number: ");
        int number = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new CrewAccepted number of car: ");
        String numberOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted type of car: ");
        String typeOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted depature time: ");
        String depatureTime = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted arrive time: ");
        String arriveTime = INPUT.nextLine();

        CrewAccepted entity = new CrewAccepted(0, number, numberOfCar, typeOfCar, depatureTime, arriveTime);
        crewAcceptedController.create(entity);
    }

    private void deleteCrewAcceptedById() throws SQLException {
        System.out.println("Enter ID to delete CrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedController.delete(id);
    }

    private void updateCrewAcceptedById() throws SQLException {
        System.out.println("Enter CrewAccepted id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        CrewAccepted oldCrewAccepted = crewAcceptedController.getService().getById(id);

        System.out.println("Enter new CrewAccepted number: ");
        int number = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new CrewAccepted number of car: ");
        String numberOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted type of car: ");
        String typeOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted depature time: ");
        String depatureTime = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted arrive time: ");
        String arriveTime = INPUT.nextLine();

        Integer newNumber = number;
        String newNumberOfCar = numberOfCar;
        String newTypeOfCar = typeOfCar;
        String newDepatureTime = depatureTime;
        String newArriveTime = arriveTime;


        if (number < 0) newNumber = oldCrewAccepted.getNumber();
        if (numberOfCar.equals("")) newNumberOfCar = oldCrewAccepted.getNumberOfCar();
        if (typeOfCar.equals("")) newTypeOfCar = oldCrewAccepted.getTypeOfCar();
        if (depatureTime.equals("")) newDepatureTime = oldCrewAccepted.getDepatureTime();
        if (arriveTime.equals("")) newArriveTime = oldCrewAccepted.getArriveTime();

        CrewAccepted entity = new CrewAccepted(id, newNumber, newNumberOfCar, newTypeOfCar, newDepatureTime, newArriveTime);
        crewAcceptedController.update(entity);
    }

    private void getAllReceivedCallHasCrewAccepteds() throws SQLException {
        System.out.println("\nTable: ReceivedCallHasCrewAccepted");
        receivedCallHasCrewAcceptedController.getAll();
    }

    private void getReceivedCallHasCrewAcceptedById() throws SQLException {
        System.out.println("Enter ID for ReceivedCallHasCrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallHasCrewAcceptedController.getById(id);
    }

    private void createReceivedCallHasCrewAccepted() throws SQLException {
        System.out.println("Enter new ReceivedCallHasCrewAccepted number of received call id: ");
        int receivedCallId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCallHasCrewAccepted number of received call id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();
        ReceivedCallHasCrewAccepted entity = new ReceivedCallHasCrewAccepted(receivedCallId, crewAcceptedId);
        receivedCallHasCrewAcceptedController.create(entity);
    }

    private void deleteReceivedCallHasCrewAcceptedById() throws SQLException {
        System.out.println("Enter ID to delete ReceivedCallHasCrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallHasCrewAcceptedController.delete(id);
    }

    private void updateReceivedCallHasCrewAcceptedById() throws SQLException {
        System.out.println("Enter ReceivedCallHasCrewAccepted id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ReceivedCallHasCrewAccepted oldReceivedCallHasCrewAccepted = receivedCallHasCrewAcceptedController.getService().getById(id);
        System.out.println("Enter new ReceivedCallHasCrewAccepted received call id: ");
        int receivedCallId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCallHasCrewAccepted crew accepted id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newReceivedCallId = receivedCallId;
        Integer newCrewAcceptedId = crewAcceptedId;


        if (receivedCallId < 0) newReceivedCallId = oldReceivedCallHasCrewAccepted.getReceivedCallId();
        if (crewAcceptedId < 0) newCrewAcceptedId = oldReceivedCallHasCrewAccepted.getCrewAcceptedId();


        ReceivedCallHasCrewAccepted entity = new ReceivedCallHasCrewAccepted(newReceivedCallId, newCrewAcceptedId);
        receivedCallHasCrewAcceptedController.update(entity);
    }

    private void getAllEmergencyDetailss() throws SQLException {
        System.out.println("\nTable: EmergencyDetails");
        emergencyDetailsController.getAll();
    }

    private void getEmergencyDetailsById() throws SQLException {
        System.out.println("Enter ID for EmergencyDetails: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        emergencyDetailsController.getById(id);
    }

    private void createEmergencyDetails() throws SQLException {
        System.out.println("Enter new EmergencyDetails type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new EmergencyDetails cause: ");
        String cause = INPUT.nextLine();

        EmergencyDetails entity = new EmergencyDetails(0, type, cause);
        emergencyDetailsController.create(entity);
    }

    private void deleteEmergencyDetailsById() throws SQLException {
        System.out.println("Enter ID to delete EmergencyDetails: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        emergencyDetailsController.delete(id);
    }

    private void updateEmergencyDetailsById() throws SQLException {
        System.out.println("Enter EmergencyDetails id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        EmergencyDetails oldEmergencyDetails = emergencyDetailsController.getService().getById(id);


        System.out.println("Enter new EmergencyDetails type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new EmergencyDetails cause: ");
        String cause = INPUT.nextLine();

        String newType = type;
        String newCause = cause;


        if (type.equals("")) newType = oldEmergencyDetails.getType();
        if (cause.equals("")) newCause = oldEmergencyDetails.getCause();


        EmergencyDetails entity = new EmergencyDetails(id, newType, newCause);
        emergencyDetailsController.update(entity);
    }

    private void getAllDescriptions() throws SQLException {
        System.out.println("\nTable: Description");
        descriptionController.getAll();
    }

    private void getDescriptionById() throws SQLException {
        System.out.println("Enter ID for Description: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        descriptionController.getById(id);
    }

    private void createDescription() throws SQLException {
        System.out.println("Enter new Description short description: ");
        String shortDescription = INPUT.nextLine();
        System.out.println("Enter new Description expanded description: ");
        String expandedDescription = INPUT.nextLine();
        System.out.println("Enter new Description emergency details id: ");
        int emergencyDetailsId = INPUT.nextInt();
        INPUT.nextLine();
        Description entity = new Description(0, shortDescription, expandedDescription, emergencyDetailsId);
        descriptionController.create(entity);
    }

    private void deleteDescriptionById() throws SQLException {
        System.out.println("Enter ID to delete Description: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        descriptionController.delete(id);
    }

    private void updateDescriptionById() throws SQLException {
        System.out.println("Enter Description id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        Description oldDescription = descriptionController.getService().getById(id);


        System.out.println("Enter new Description short description: ");
        String shortDescription = INPUT.nextLine();
        System.out.println("Enter new Description expanded description: ");
        String expandedDescription = INPUT.nextLine();
        System.out.println("Enter new Description emergency details id: ");
        int emergencyDetailsId = INPUT.nextInt();
        INPUT.nextLine();

        String newShortDescription = shortDescription;
        String newExpandedDescription = expandedDescription;
        Integer newEmergencyDetailsId = emergencyDetailsId;


        if (shortDescription.equals("")) newShortDescription = oldDescription.getShortDescription();
        if (expandedDescription.equals("")) newExpandedDescription = oldDescription.getExpandedDescription();
        if (emergencyDetailsId < 0) newEmergencyDetailsId = oldDescription.getEmergencyDetailsId();


        Description entity = new Description(id, newShortDescription, newExpandedDescription, newEmergencyDetailsId);
        descriptionController.update(entity);
    }


    private void getAllPersonInformationReports() throws SQLException {
        System.out.println("\nTable: PersonInformationReport");
        personInformationReportController.getAll();
    }

    private void getPersonInformationReportById() throws SQLException {
        System.out.println("Enter ID for PersonInformationReport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationReportController.getById(id);
    }

    private void createPersonInformationReport() throws SQLException {

        System.out.println("Enter new PersonInformationReport name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport phone number: ");
        String phoneNumber = INPUT.nextLine();



        PersonInformationReport entity = new PersonInformationReport(0, name, lastName, phoneNumber);
        personInformationReportController.create(entity);
    }

    private void deletePersonInformationReportById() throws SQLException {
        System.out.println("Enter ID to delete PersonInformationReport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationReportController.delete(id);
    }

    private void updatePersonInformationReportById() throws SQLException {
        System.out.println("Enter PersonInformationReport id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PersonInformationReport oldPersonInformationReport = personInformationReportController.getService().getById(id);
        System.out.println("Enter new PersonInformationReport name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport phone number: ");
        String phoneNumber = INPUT.nextLine();


        String newName = name;
        String newLastName = lastName;
        String newPhoneNumber = phoneNumber;

        if (name.equals("")) newName = oldPersonInformationReport.getName();
        if (lastName.equals("")) newLastName = oldPersonInformationReport.getLastName();
        if (phoneNumber.equals("")) newPhoneNumber = oldPersonInformationReport.getPhoneNumber();


        PersonInformationReport entity = new PersonInformationReport(id, newName, newLastName, newPhoneNumber);
        personInformationReportController.update(entity);
    }


    private void getAllReceivedCalls() throws SQLException {
        System.out.println("\nTable: ReceivedCall");
        receivedCallController.getAll();
    }

    private void getReceivedCallById() throws SQLException {
        System.out.println("Enter ID for ReceivedCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallController.getById(id);
    }

    private void createReceivedCall() throws SQLException {

        System.out.println("Enter new ReceivedCall description id: ");
        int descriptionId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCall address: ");
        String address = INPUT.nextLine();
        System.out.println("Enter new ReceivedCall person information id: ");
        int personInformationId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCall datetime: ");
        String dateTime = INPUT.nextLine();
        ReceivedCall entity = new ReceivedCall(0, descriptionId, address, personInformationId, dateTime);
        receivedCallController.create(entity);
    }

    private void deleteReceivedCallById() throws SQLException {
        System.out.println("Enter ID to delete ReceivedCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallController.delete(id);
    }

    private void updateReceivedCallById() throws SQLException {
        System.out.println("Enter ReceivedCall id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ReceivedCall oldReceivedCall = receivedCallController.getService().getById(id);

        System.out.println("Enter new ReceivedCall description id: ");
        int descriptionId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCall address: ");
        String address = INPUT.nextLine();
        System.out.println("Enter new ReceivedCall person information id: ");
        int personInformationId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new ReceivedCall datetime: ");
        String dateTime = INPUT.nextLine();

        Integer newDescriptionId = descriptionId;
        String newAddress = address;
        Integer newPersonInformationId = personInformationId;
        String newDateTime = dateTime;


        if (descriptionId < 0) newDescriptionId = oldReceivedCall.getDescriptionId();
        if (address.equals("")) newAddress = oldReceivedCall.getAddress();
        if (personInformationId < 0) newPersonInformationId = oldReceivedCall.getPersonInformationReportId();
        if (newDateTime.equals("")) newDateTime = oldReceivedCall.getDatetime();


        ReceivedCall entity = new ReceivedCall(id, newDescriptionId, newAddress, newPersonInformationId, newDateTime);
        receivedCallController.update(entity);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));
    }


}


