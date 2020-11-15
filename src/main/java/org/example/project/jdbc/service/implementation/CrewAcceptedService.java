package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.CrewAcceptedDAO;
import org.example.project.jdbc.model.implementation.CrewAccepted;

public class CrewAcceptedService extends GeneralService<CrewAccepted> {

    public GeneralDAOInterface<CrewAccepted, Integer> crewAcceptedDAO = new CrewAcceptedDAO();

    @Override
    public GeneralDAOInterface<CrewAccepted, Integer> getDAO() {
        return crewAcceptedDAO;
    }
}
