package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.ReceivedCallDAO;
import org.example.project.jdbc.model.implementation.ReceivedCall;


public class ReceivedCallService extends GeneralService<ReceivedCall> {
    private final GeneralDAOInterface<ReceivedCall> RECEIVED_CALL_DAO = new ReceivedCallDAO();

    @Override
    public GeneralDAOInterface<ReceivedCall> getDAO() {
        return RECEIVED_CALL_DAO;
    }

}
