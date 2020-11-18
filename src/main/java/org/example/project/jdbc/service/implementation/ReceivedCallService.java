package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.ReceivedCallDAO;
import org.example.project.jdbc.model.implementation.ReceivedCall;


public class ReceivedCallService extends GeneralService<ReceivedCall> {
    public GeneralDAOInterface<ReceivedCall, Integer> receivedCallDAO = new ReceivedCallDAO();

    @Override
    public GeneralDAOInterface<ReceivedCall, Integer> getDAO() {
        return receivedCallDAO;
    }

}
