package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.CrewAccepted;
import org.example.project.jdbc.service.GeneralServiceInterface;
import org.example.project.jdbc.service.implementation.CrewAcceptedService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class CrewAcceptedController extends GeneralController<CrewAccepted> {

    private final GeneralService<CrewAccepted> crewAcceptedService = new CrewAcceptedService();

    @Override
    public final GeneralServiceInterface<CrewAccepted> getService() {
        return crewAcceptedService;
    }

}

