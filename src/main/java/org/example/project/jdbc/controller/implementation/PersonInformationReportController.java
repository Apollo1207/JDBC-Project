package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.PersonInformationReport;
import org.example.project.jdbc.service.GeneralServiceInterface;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.PersonInformationReportService;

public class PersonInformationReportController extends GeneralController<PersonInformationReport> {

    private final GeneralService<PersonInformationReport> personInformationReportService = new PersonInformationReportService();

    @Override
    public final GeneralServiceInterface<PersonInformationReport> getService() {
        return personInformationReportService;
    }

}
