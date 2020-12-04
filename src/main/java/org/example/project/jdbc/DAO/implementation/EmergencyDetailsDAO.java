package org.example.project.jdbc.DAO.implementation;


import org.example.project.jdbc.model.implementation.EmergencyDetails;

public class EmergencyDetailsDAO extends GeneralDAO<EmergencyDetails> {

    @Override
    public final Class<EmergencyDetails> getClazz() {
        return EmergencyDetails.class;
    }

}
