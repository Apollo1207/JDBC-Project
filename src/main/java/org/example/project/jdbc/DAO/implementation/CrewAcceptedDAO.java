package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.model.implementation.CrewAccepted;

public class CrewAcceptedDAO extends GeneralDAO<CrewAccepted> {

    @Override
    public final Class<CrewAccepted> getClazz() {
        return CrewAccepted.class;
    }

}

