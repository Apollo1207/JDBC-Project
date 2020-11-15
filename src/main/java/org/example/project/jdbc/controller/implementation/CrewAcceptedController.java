package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.CrewAccepted;
import org.example.project.jdbc.service.implementation.CrewAcceptedService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class CrewAcceptedController extends GeneralController<CrewAccepted> {

    public static final CrewAcceptedService crewAcceptedService = new CrewAcceptedService();

    @Override
    public GeneralService<CrewAccepted> getService() {
        return crewAcceptedService;
    }
}

