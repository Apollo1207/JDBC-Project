package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.CrewAcceptedDAO;
import org.example.project.jdbc.model.implementation.CrewAccepted;

public class CrewAcceptedService extends GeneralService<CrewAccepted> {

    private final GeneralDAOInterface<CrewAccepted> CREW_ACCEPTED_DAO = new CrewAcceptedDAO();

    @Override
    public GeneralDAOInterface<CrewAccepted> getDAO() {
        return CREW_ACCEPTED_DAO;
    }
}
