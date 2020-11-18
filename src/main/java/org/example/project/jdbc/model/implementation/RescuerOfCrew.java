package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;


public class RescuerOfCrew implements GeneralModelInterface {
    private Integer id;
    private String name;
    private String lastName;
    private String surName;
    private Integer numberOfToken;
    private String rankPosition;
    private String dateOfBirth;
    private String addressOfResidence;
    private Integer injuryOnCallId;

    public RescuerOfCrew(Integer id, String name, String lastName, String surName, Integer numberOfToken, String rankPosition, String dateOfBirth, String addressOfResidence, Integer injuryOnCallId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.surName = surName;
        this.numberOfToken = numberOfToken;
        this.rankPosition = rankPosition;
        this.dateOfBirth = dateOfBirth;
        this.addressOfResidence = addressOfResidence;
        this.injuryOnCallId = injuryOnCallId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getNumberOfToken() {
        return numberOfToken;
    }

    public void setNumberOfToken(Integer numberOfToken) {
        this.numberOfToken = numberOfToken;
    }

    public String getRankPosition() {
        return rankPosition;
    }

    public void setRankPosition(String rankPosition) {
        this.rankPosition = rankPosition;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public Integer getInjuryOnCallId() {
        return injuryOnCallId;
    }

    public void setInjuryOnCallId(Integer injuryOnCallId) {
        this.injuryOnCallId = injuryOnCallId;
    }

    @Override
    public String toString() {
        return "RescuerOfCrew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", numberOfToken=" + numberOfToken +
                ", rankPosition='" + rankPosition + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", addressOfResidence='" + addressOfResidence + '\'' +
                ", injuryOnCallId=" + injuryOnCallId +
                '}';
    }
}
