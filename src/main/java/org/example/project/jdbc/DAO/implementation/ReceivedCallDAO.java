package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.model.implementation.ReceivedCall;

public class ReceivedCallDAO extends GeneralDAO<ReceivedCall> {

    @Override
    public final Class<ReceivedCall> getClazz() {
        return ReceivedCall.class;
    }

}
