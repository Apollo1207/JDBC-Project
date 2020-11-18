package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class Description implements GeneralModelInterface {
    private Integer id;
    private String shortDescription;
    private String expandedDescription;
    private Integer emergencyDetailsId;

    public Description(Integer id, String shortDescription, String expandedDescription, Integer emergencyDetailsId) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.expandedDescription = expandedDescription;
        this.emergencyDetailsId = emergencyDetailsId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getExpandedDescription() {
        return expandedDescription;
    }

    public void setExpandedDescription(String expandedDescription) {
        this.expandedDescription = expandedDescription;
    }

    public Integer getEmergencyDetailsId() {
        return emergencyDetailsId;
    }

    public void setEmergencyDetailsId(Integer emergencyDetailsId) {
        this.emergencyDetailsId = emergencyDetailsId;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", shortDescription='" + shortDescription + '\'' +
                ", expandedDescription='" + expandedDescription + '\'' +
                ", emergencyDetailsId=" + emergencyDetailsId +
                '}';
    }
}
