package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.CrewAcceptedHasRescuerOfCrew;
import org.example.project.jdbc.service.implementation.CrewAcceptedHasRescuerOfCrewService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class CrewAcceptedHasRescuerOfCrewController extends GeneralController<CrewAcceptedHasRescuerOfCrew> {

    public static final CrewAcceptedHasRescuerOfCrewService crewAcceptedHasRescuerOfCrewService = new CrewAcceptedHasRescuerOfCrewService();

    @Override
    public GeneralService<CrewAcceptedHasRescuerOfCrew> getService() {
        return crewAcceptedHasRescuerOfCrewService;
    }
}