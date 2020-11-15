package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.ReceivedCallHasCrewAccepted;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.ReceivedCallHasCrewAcceptedService;

public class ReceivedCallHasCrewAcceptedController extends GeneralController<ReceivedCallHasCrewAccepted> {

    public static final ReceivedCallHasCrewAcceptedService receivedCallHasCrewAcceptedService = new ReceivedCallHasCrewAcceptedService();

    @Override
    public GeneralService<ReceivedCallHasCrewAccepted> getService() {
        return receivedCallHasCrewAcceptedService;
    }
}

