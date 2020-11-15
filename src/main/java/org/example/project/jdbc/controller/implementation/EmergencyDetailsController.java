package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.EmergencyDetails;
import org.example.project.jdbc.service.implementation.EmergencyDetailsService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class EmergencyDetailsController extends GeneralController<EmergencyDetails> {

    public static final EmergencyDetailsService emergencyDetailsService = new EmergencyDetailsService();

    @Override
    public GeneralService<EmergencyDetails> getService() {
        return emergencyDetailsService;
    }
}
