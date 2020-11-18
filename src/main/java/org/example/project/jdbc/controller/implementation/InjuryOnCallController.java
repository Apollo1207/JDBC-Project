package org.example.project.jdbc.controller.implementation;

import org.example.project.jdbc.model.implementation.InjuryOnCall;
import org.example.project.jdbc.service.implementation.GeneralService;
import org.example.project.jdbc.service.implementation.InjuryOnCallService;

public class InjuryOnCallController extends GeneralController<InjuryOnCall> {

    public static final InjuryOnCallService injuryOnCallService = new InjuryOnCallService();

    @Override
    public GeneralService<InjuryOnCall> getService() {

        return injuryOnCallService;
    }
}
