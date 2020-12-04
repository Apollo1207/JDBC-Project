package org.example.project.jdbc.view;

import org.example.project.jdbc.controller.implementation.*;
import org.example.project.jdbc.model.implementation.*;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class MainView {
    private static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    private final CrewAcceptedController crewAcceptedController = new CrewAcceptedController();
    private final EmergencyDetailsController emergencyDetailsController = new EmergencyDetailsController();
    private final DescriptionController descriptionController = new DescriptionController();
    private final PersonInformationReportController personInformationReportController = new PersonInformationReportController();
    private final ReceivedCallController receivedCallController = new ReceivedCallController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;

    public MainView(Session session) {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("41", "41 - Get all crewAccepteds");
        menu.put("42", "42 - Get crewAccepted by ID");
        menu.put("43", "43 - Create crewAccepted");
        menu.put("44", "44 - Delete crewAccepted by ID");
        menu.put("45", "45 - Update crewAccepted by ID");

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


        methodsMenu.put("41", () -> getAllCrewAccepteds(session));
        methodsMenu.put("42", () -> getCrewAcceptedById(session));
        methodsMenu.put("43", () -> createCrewAccepted(session));
        methodsMenu.put("44", () -> deleteCrewAcceptedById(session));
        methodsMenu.put("45", () -> updateCrewAcceptedById(session));

        methodsMenu.put("61", () -> getAllEmergencyDetailss(session));
        methodsMenu.put("62", () -> getEmergencyDetailsById(session));
        methodsMenu.put("63", () -> createEmergencyDetails(session));
        methodsMenu.put("64", () -> deleteEmergencyDetailsById(session));
        methodsMenu.put("65", () -> updateEmergencyDetailsById(session));

        methodsMenu.put("71", () -> getAllDescriptions(session));
        methodsMenu.put("72", () -> getDescriptionById(session));
        methodsMenu.put("73", () -> createDescription(session));
        methodsMenu.put("74", () -> deleteDescriptionById(session));
        methodsMenu.put("75", () -> updateDescriptionById(session));

        methodsMenu.put("81", () -> getAllPersonInformationReports(session));
        methodsMenu.put("82", () -> getPersonInformationReportById(session));
        methodsMenu.put("83", () -> createPersonInformationReport(session));
        methodsMenu.put("84", () -> deletePersonInformationReportById(session));
        methodsMenu.put("85", () -> updatePersonInformationReportById(session));

        methodsMenu.put("91", () -> getAllReceivedCalls(session));
        methodsMenu.put("92", () -> getReceivedCallById(session));
        methodsMenu.put("93", () -> createReceivedCall(session));
        methodsMenu.put("94", () -> deleteReceivedCallById(session));
        methodsMenu.put("95", () -> updateReceivedCallById(session));
    }


    private void getAllCrewAccepteds(Session session) throws SQLException {
        System.out.println("\nTable: CrewAccepted");
        crewAcceptedController.getAll(session);
    }

    private void getCrewAcceptedById(Session session) throws SQLException {
        System.out.println("Enter ID for CrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedController.getById(id, session);
    }

    private void createCrewAccepted(Session session) throws SQLException {
        System.out.println("Enter new CrewAccepted number: ");
        String number = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted number of car: ");
        String numberOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted type of car: ");
        String typeOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted depature time: ");
        String depatureTime = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted arrive time: ");
        String arriveTime = INPUT.nextLine();

        CrewAccepted entity = new CrewAccepted(0, number, numberOfCar, typeOfCar, depatureTime, arriveTime);
        crewAcceptedController.create(entity, session);
    }

    private void deleteCrewAcceptedById(Session session) throws SQLException {
        System.out.println("Enter ID to delete CrewAccepted: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        crewAcceptedController.delete(id, session);
    }

    private void updateCrewAcceptedById(Session session) throws SQLException {
        System.out.println("Enter CrewAccepted id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        CrewAccepted oldCrewAccepted = crewAcceptedController.getService().getById(id, session);

        System.out.println("Enter new CrewAccepted number: ");
        String number = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted number of car: ");
        String numberOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted type of car: ");
        String typeOfCar = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted depature time: ");
        String depatureTime = INPUT.nextLine();
        System.out.println("Enter new CrewAccepted arrive time: ");
        String arriveTime = INPUT.nextLine();

        String newNumber = number;
        String newNumberOfCar = numberOfCar;
        String newTypeOfCar = typeOfCar;
        String newDepatureTime = depatureTime;
        String newArriveTime = arriveTime;


        if (number.equals("")) newNumber = oldCrewAccepted.getNumber();
        if (numberOfCar.equals("")) newNumberOfCar = oldCrewAccepted.getNumberOfCar();
        if (typeOfCar.equals("")) newTypeOfCar = oldCrewAccepted.getTypeOfCar();
        if (depatureTime.equals("")) newDepatureTime = oldCrewAccepted.getDepatureTime();
        if (arriveTime.equals("")) newArriveTime = oldCrewAccepted.getArriveTime();

        CrewAccepted entity = new CrewAccepted(id, newNumber, newNumberOfCar, newTypeOfCar, newDepatureTime, newArriveTime);
        crewAcceptedController.update(entity, session);
    }


    private void getAllEmergencyDetailss(Session session) throws SQLException {
        System.out.println("\nTable: EmergencyDetails");
        emergencyDetailsController.getAll(session);
    }

    private void getEmergencyDetailsById(Session session) throws SQLException {
        System.out.println("Enter ID for EmergencyDetails: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        emergencyDetailsController.getById(id, session);
    }

    private void createEmergencyDetails(Session session) throws SQLException {
        System.out.println("Enter new EmergencyDetails type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new EmergencyDetails cause: ");
        String cause = INPUT.nextLine();

        EmergencyDetails entity = new EmergencyDetails(0, type, cause);
        emergencyDetailsController.create(entity, session);
    }

    private void deleteEmergencyDetailsById(Session session) throws SQLException {
        System.out.println("Enter ID to delete EmergencyDetails: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        emergencyDetailsController.delete(id, session);
    }

    private void updateEmergencyDetailsById(Session session) throws SQLException {
        System.out.println("Enter EmergencyDetails id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        EmergencyDetails oldEmergencyDetails = emergencyDetailsController.getService().getById(id, session);


        System.out.println("Enter new EmergencyDetails type: ");
        String type = INPUT.nextLine();
        System.out.println("Enter new EmergencyDetails cause: ");
        String cause = INPUT.nextLine();

        String newType = type;
        String newCause = cause;


        if (type.equals("")) newType = oldEmergencyDetails.getType();
        if (cause.equals("")) newCause = oldEmergencyDetails.getCause();


        EmergencyDetails entity = new EmergencyDetails(id, newType, newCause);
        emergencyDetailsController.update(entity, session);
    }

    private void getAllDescriptions(Session session) throws SQLException {
        System.out.println("\nTable: Description");
        descriptionController.getAll(session);
    }

    private void getDescriptionById(Session session) throws SQLException {
        System.out.println("Enter ID for Description: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        descriptionController.getById(id, session);
    }

    private void createDescription(Session session) throws SQLException {
        System.out.println("Enter new Description short description: ");
        String shortDesc = INPUT.nextLine();
        System.out.println("Enter new Description expanded description: ");
        String expandedDesc = INPUT.nextLine();
        System.out.println("Enter new Description emergency details id: ");
        int emergencyDetailsId = INPUT.nextInt();
        INPUT.nextLine();

        EmergencyDetails emergencyDetails = emergencyDetailsController.getService().getById(emergencyDetailsId, session);
        Description entity = new Description(0, shortDesc, expandedDesc, emergencyDetails);
        descriptionController.create(entity, session);
    }

    private void deleteDescriptionById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Description: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        descriptionController.delete(id, session);
    }

    private void updateDescriptionById(Session session) throws SQLException {
        System.out.println("Enter Description id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        Description oldDescription = descriptionController.getService().getById(id, session);


        System.out.println("Enter new Description short description: ");
        String shortDesc = INPUT.nextLine();
        System.out.println("Enter new Description expanded description: ");
        String expandedDesc = INPUT.nextLine();
        System.out.println("Enter new Description emergency details id: ");
        int emergencyDetailsId = INPUT.nextInt();
        INPUT.nextLine();

        String newShortDesc = shortDesc;
        String newExpandedDesc = expandedDesc;
        EmergencyDetails newEmergencyDetailsId = emergencyDetailsController.getService().getById(emergencyDetailsId, session);


        if (shortDesc.equals("")) newShortDesc = oldDescription.getShortDesc();
        if (expandedDesc.equals("")) newExpandedDesc = oldDescription.getExpandedDesc();

        Description entity = new Description();
        entity.setShortDesc(newShortDesc);
        entity.setExpandedDesc(newExpandedDesc);
        entity.setEmergencyDetailsByEmergencyDetailsId(newEmergencyDetailsId);
        descriptionController.update(entity, session);
    }


    private void getAllPersonInformationReports(Session session) throws SQLException {
        System.out.println("\nTable: PersonInformationReport");
        personInformationReportController.getAll(session);
    }

    private void getPersonInformationReportById(Session session) throws SQLException {
        System.out.println("Enter ID for PersonInformationReport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationReportController.getById(id, session);
    }

    private void createPersonInformationReport(Session session) throws SQLException {

        System.out.println("Enter new PersonInformationReport name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new PersonInformationReport phone number: ");
        String phoneNumber = INPUT.nextLine();


        PersonInformationReport entity = new PersonInformationReport(0, name, lastName, phoneNumber);
        personInformationReportController.create(entity, session);
    }

    private void deletePersonInformationReportById(Session session) throws SQLException {
        System.out.println("Enter ID to delete PersonInformationReport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationReportController.delete(id, session);
    }

    private void updatePersonInformationReportById(Session session) throws SQLException {
        System.out.println("Enter PersonInformationReport id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PersonInformationReport oldPersonInformationReport = personInformationReportController.getService().getById(id, session);
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
        personInformationReportController.update(entity, session);
    }


    private void getAllReceivedCalls(Session session) throws SQLException {
        System.out.println("\nTable: ReceivedCall");
        receivedCallController.getAll(session);
    }

    private void getReceivedCallById(Session session) throws SQLException {
        System.out.println("Enter ID for ReceivedCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallController.getById(id, session);
    }

    private void createReceivedCall(Session session) throws SQLException {

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
        System.out.println("Enter new ReceivedCall crew accepted id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();

        Description description = descriptionController.getService().getById(descriptionId, session);
        PersonInformationReport personInformationReport = personInformationReportController.getService().getById(personInformationId, session);
        CrewAccepted crewAccepted = crewAcceptedController.getService().getById(crewAcceptedId, session);

        ReceivedCall entity = new ReceivedCall(0, description, address, personInformationReport, dateTime, crewAccepted);
        receivedCallController.create(entity, session);
    }

    private void deleteReceivedCallById(Session session) throws SQLException {
        System.out.println("Enter ID to delete ReceivedCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        receivedCallController.delete(id, session);
    }

    private void updateReceivedCallById(Session session) throws SQLException {
        System.out.println("Enter ReceivedCall id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ReceivedCall oldReceivedCall = receivedCallController.getService().getById(id, session);

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
        System.out.println("Enter new ReceivedCall crew accepted id: ");
        int crewAcceptedId = INPUT.nextInt();
        INPUT.nextLine();

        Description newDescriptionId = descriptionController.getService().getById(descriptionId, session);
        String newAddress = address;
        PersonInformationReport newPersonInformationId = personInformationReportController.getService().getById(personInformationId, session);
        String newDateTime = dateTime;
        CrewAccepted newCrewAcceptedId = crewAcceptedController.getService().getById(crewAcceptedId, session);


        if (address.equals("")) newAddress = oldReceivedCall.getAddress();
        if (newDateTime.equals("")) newDateTime = oldReceivedCall.getDateTime();

        ReceivedCall entity = new ReceivedCall(id, newDescriptionId, newAddress, newPersonInformationId, newDateTime, newCrewAcceptedId);
        receivedCallController.update(entity, session);
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


