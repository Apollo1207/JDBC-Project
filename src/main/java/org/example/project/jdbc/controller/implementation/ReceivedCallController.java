package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.ReceivedCall;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.ReceivedCallService;

public class ReceivedCallController extends GeneralController<ReceivedCall> {

    public static final ReceivedCallService receivedCallService = new ReceivedCallService();

    @Override
    public GeneralService<ReceivedCall> getService() {
        return receivedCallService;
    }
}

