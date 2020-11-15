package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.PersonInformationReport;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.PersonInformationReportService;

public class PersonInformationReportController extends GeneralController<PersonInformationReport> {

    public static final PersonInformationReportService personInformationReportService = new PersonInformationReportService();

    @Override
    public GeneralService<PersonInformationReport> getService() {
        return personInformationReportService;
    }
}
