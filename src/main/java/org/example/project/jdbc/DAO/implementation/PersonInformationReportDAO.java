package org.example.project.jdbc.DAO.implementation;

import org.example.project.jdbc.model.implementation.PersonInformationReport;

public class PersonInformationReportDAO extends GeneralDAO<PersonInformationReport> {

    @Override
    public final Class<PersonInformationReport> getClazz() {
        return PersonInformationReport.class;
    }

}

