package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class InjuryOnCall implements GeneralModelInterface {
    private Integer id;
    private String nameOfInjury;
    private String descriptionOfInjury;
    private String numberOfHospital;
    private String diagnosis;

    public InjuryOnCall(Integer id, String nameOfInjury, String descriptionOfInjury, String numberOfHospital, String diagnosis) {
        this.id = id;
        this.nameOfInjury = nameOfInjury;
        this.descriptionOfInjury = descriptionOfInjury;
        this.numberOfHospital = numberOfHospital;
        this.diagnosis = diagnosis;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfInjury() {
        return nameOfInjury;
    }

    public void setNameOfInjury(String nameOfInjury) {
        this.nameOfInjury = nameOfInjury;
    }

    public String getDescriptionOfInjury() {
        return descriptionOfInjury;
    }

    public void setDescriptionOfInjury(String descriptionOfInjury) {
        this.descriptionOfInjury = descriptionOfInjury;
    }

    public String getNumberOfHospital() {
        return numberOfHospital;
    }

    public void setNumberOfHospital(String numberOfHospital) {
        this.numberOfHospital = numberOfHospital;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "InjuryOnCall{" +
                "id=" + id +
                ", nameOfInjury='" + nameOfInjury + '\'' +
                ", descriptionOfInjury='" + descriptionOfInjury + '\'' +
                ", numberOfHospital='" + numberOfHospital + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
