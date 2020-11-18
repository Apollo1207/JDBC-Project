package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.PersonInformationReportDAO;
import org.example.project.jdbc.model.implementation.PersonInformationReport;

public class PersonInformationReportService extends GeneralService<PersonInformationReport> {
    public GeneralDAOInterface<PersonInformationReport, Integer> personInformationReportDAO = new PersonInformationReportDAO();

    @Override
    public GeneralDAOInterface<PersonInformationReport, Integer> getDAO() {
        return personInformationReportDAO;
    }

}
