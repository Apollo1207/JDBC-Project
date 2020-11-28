package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.EmergencyDetailsDAO;
import org.example.project.jdbc.model.implementation.EmergencyDetails;

public class EmergencyDetailsService extends GeneralService<EmergencyDetails> {

    private final GeneralDAOInterface<EmergencyDetails> EMERGENCY_DETAILS_DAO = new EmergencyDetailsDAO();

    @Override
    public GeneralDAOInterface<EmergencyDetails> getDAO() {
        return EMERGENCY_DETAILS_DAO;
    }

}
