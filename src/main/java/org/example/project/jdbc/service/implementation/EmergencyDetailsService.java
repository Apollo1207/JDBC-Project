package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.EmergencyDetailsDAO;
import org.example.project.jdbc.model.implementation.EmergencyDetails;

public class EmergencyDetailsService extends GeneralService<EmergencyDetails> {
    public GeneralDAOInterface<EmergencyDetails, Integer> emergencyDetailsDAO = new EmergencyDetailsDAO();

    @Override
    public GeneralDAOInterface<EmergencyDetails, Integer> getDAO() {
        return emergencyDetailsDAO;
    }

}
