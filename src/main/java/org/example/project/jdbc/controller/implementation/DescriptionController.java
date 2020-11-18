package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.Description;
import org.example.project.jdbc.service.implementation.DescriptionService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class DescriptionController extends GeneralController<Description> {

    public static final DescriptionService descriptionService = new DescriptionService();

    @Override
    public GeneralService<Description> getService() {
        return descriptionService;
    }
}
