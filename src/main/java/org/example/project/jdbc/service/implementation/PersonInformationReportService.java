package org.example.project.jdbc.service.implementation;

import org.example.project.jdbc.DAO.GeneralDAOInterface;
import org.example.project.jdbc.DAO.implementation.PersonInformationReportDAO;
import org.example.project.jdbc.model.implementation.PersonInformationReport;

public class PersonInformationReportService extends GeneralService<PersonInformationReport> {
    private final GeneralDAOInterface<PersonInformationReport> PERSON_INFORMATION_REPORT_DAO = new PersonInformationReportDAO();

    @Override
    public GeneralDAOInterface<PersonInformationReport> getDAO() {
        return PERSON_INFORMATION_REPORT_DAO;
    }

}
