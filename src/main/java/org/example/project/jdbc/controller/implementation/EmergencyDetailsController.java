package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.EmergencyDetails;
import org.example.project.jdbc.service.GeneralServiceInterface;
import org.example.project.jdbc.service.implementation.EmergencyDetailsService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class EmergencyDetailsController extends GeneralController<EmergencyDetails> {

    private final GeneralService<EmergencyDetails> emergencyDetailsService = new EmergencyDetailsService();

    @Override
    public final GeneralServiceInterface<EmergencyDetails> getService() {
        return emergencyDetailsService;
    }

}
