package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class CrewAcceptedHasRescuerOfCrew implements GeneralModelInterface {
    private Integer crewAcceptedId;
    private Integer rescuerOfCrewId;

    public CrewAcceptedHasRescuerOfCrew(Integer crewAcceptedId, Integer rescuerOfCrewId) {
        this.crewAcceptedId = crewAcceptedId;
        this.rescuerOfCrewId = rescuerOfCrewId;
    }

    public Integer getCrewAcceptedId() {
        return crewAcceptedId;
    }

    public void setCrewAcceptedId(Integer crewAcceptedId) {
        this.crewAcceptedId = crewAcceptedId;
    }

    public Integer getRescuerOfCrewId() {
        return rescuerOfCrewId;
    }

    public void setRescuerOfCrewId(Integer rescuerOfCrewId) {
        this.rescuerOfCrewId = rescuerOfCrewId;
    }

    @Override
    public String toString() {
        return "crewAcceptedHasRescuerOfCrew{" +
                "crewAcceptedId=" + crewAcceptedId +
                ", rescuerOfCrewId=" + rescuerOfCrewId +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
