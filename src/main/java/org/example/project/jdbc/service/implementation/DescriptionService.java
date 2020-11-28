package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.DescriptionDAO;
import org.example.project.jdbc.model.implementation.Description;

public class DescriptionService extends GeneralService<Description> {

    private final GeneralDAOInterface<Description> DESCRIPTION_DAO = new DescriptionDAO();

    @Override
    public GeneralDAOInterface<Description> getDAO() {
        return DESCRIPTION_DAO;
    }

}
