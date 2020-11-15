package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.InjuryOnCallDAO;
import org.example.project.jdbc.model.implementation.InjuryOnCall;

public class InjuryOnCallService extends GeneralService<InjuryOnCall> {
    public GeneralDAOInterface<InjuryOnCall, Integer> injuryOnCallDAOImplementation = new InjuryOnCallDAO();

    @Override
    public GeneralDAOInterface<InjuryOnCall, Integer> getDAO() {
        return injuryOnCallDAOImplementation;
    }
}
