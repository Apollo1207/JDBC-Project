package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class ReceivedCall implements GeneralModelInterface {
    private Integer id;
    private Integer descriptionId;
    private String address;
    private Integer personInformationReportId;
    private String datetime;

    public ReceivedCall(Integer id, Integer descriptionId, String address, Integer personInformationReportId, String datetime) {

//        java.util.Date dt = new java.util.Date();
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.id = id;
        this.descriptionId = descriptionId;
        this.address = address;
        this.personInformationReportId = personInformationReportId;
        this.datetime = datetime;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPersonInformationReportId() {
        return personInformationReportId;
    }

    public void setPersonInformationReportId(Integer personInformationReportId) {
        this.personInformationReportId = personInformationReportId;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "ReceivedCall{" +
                "id=" + id +
                ", descriptionId=" + descriptionId +
                ", address='" + address + '\'' +
                ", personInformationReportId=" + personInformationReportId +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}

