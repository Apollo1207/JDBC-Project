package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.DescriptionDAO;
import org.example.project.jdbc.model.implementation.Description;

public class DescriptionService extends GeneralService<Description> {
    public GeneralDAOInterface<Description, Integer> descriptionDAO = new DescriptionDAO();

    @Override
    public GeneralDAOInterface<Description, Integer> getDAO() {
        return descriptionDAO;
    }

}
