package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.ReceivedCallHasCrewAcceptedDAO;
import org.example.project.jdbc.model.implementation.ReceivedCallHasCrewAccepted;


public class ReceivedCallHasCrewAcceptedService extends GeneralService<ReceivedCallHasCrewAccepted> {
    public GeneralDAOInterface<ReceivedCallHasCrewAccepted, Integer> receivedCallHasCrewAcceptedDAO = new ReceivedCallHasCrewAcceptedDAO();

    @Override
    public GeneralDAOInterface<ReceivedCallHasCrewAccepted, Integer> getDAO() {
        return receivedCallHasCrewAcceptedDAO;
    }

}
