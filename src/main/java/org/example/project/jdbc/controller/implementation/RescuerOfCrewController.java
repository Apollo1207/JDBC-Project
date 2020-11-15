package org.example.project.jdbc.controller.implementation;


import org.example.project.jdbc.model.implementation.RescuerOfCrew;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.RescuerOfCrewService;

public class RescuerOfCrewController extends GeneralController<RescuerOfCrew> {

    public static final RescuerOfCrewService rescuerOfCrewService = new RescuerOfCrewService();

    @Override
    public GeneralService<RescuerOfCrew> getService() {
        return rescuerOfCrewService;
    }
}
