package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.Description;
import org.example.project.jdbc.service.GeneralServiceInterface;
import org.example.project.jdbc.service.implementation.DescriptionService;
import org.example.project.jdbc.service.implementation.GeneralService;

public class DescriptionController extends GeneralController<Description> {

    private final GeneralService<Description> descriptionService = new DescriptionService();

    @Override
    public final GeneralServiceInterface<Description> getService() {
        return descriptionService;
    }
}


