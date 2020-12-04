package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.ReceivedCall;
import org.example.project.jdbc.service.GeneralServiceInterface;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.ReceivedCallService;

public class ReceivedCallController extends GeneralController<ReceivedCall> {

    private final GeneralService<ReceivedCall> receivedCallService = new ReceivedCallService();

    @Override
    public final GeneralServiceInterface<ReceivedCall> getService() {
        return receivedCallService;
    }

}

