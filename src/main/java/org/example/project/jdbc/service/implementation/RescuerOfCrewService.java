package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.RescuerOfCrewDAO;
import org.example.project.jdbc.model.implementation.RescuerOfCrew;


public class RescuerOfCrewService extends GeneralService<RescuerOfCrew> {
    public GeneralDAOInterface<RescuerOfCrew, Integer> rescuerOfCrewDAO = new RescuerOfCrewDAO();

    @Override
    public GeneralDAOInterface<RescuerOfCrew, Integer> getDAO() {
        return rescuerOfCrewDAO;
    }

}
