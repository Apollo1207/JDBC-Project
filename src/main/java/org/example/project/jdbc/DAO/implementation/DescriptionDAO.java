package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.model.implementation.Description;

public class DescriptionDAO extends GeneralDAO<Description> {

    @Override
    public final Class<Description> getClazz() {
        return Description.class;
    }

}