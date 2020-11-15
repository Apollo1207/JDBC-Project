package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.CrewAcceptedHasRescuerOfCrewDAO;
import org.example.project.jdbc.model.implementation.CrewAcceptedHasRescuerOfCrew;

public class CrewAcceptedHasRescuerOfCrewService extends GeneralService<CrewAcceptedHasRescuerOfCrew> {
    public GeneralDAOInterface<CrewAcceptedHasRescuerOfCrew, Integer> crewAcceptedHasRescuerOfCrewDAO = new CrewAcceptedHasRescuerOfCrewDAO();

    @Override
    public GeneralDAOInterface<CrewAcceptedHasRescuerOfCrew, Integer> getDAO() {
        return crewAcceptedHasRescuerOfCrewDAO;
    }

}
