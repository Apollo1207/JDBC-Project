package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "received_call", schema = "fedyniak_illya_db", catalog = "")
public class ReceivedCall implements GeneralModelInterface {
    private Integer id;
    private Description descriptionByDescriptionId;
    private String address;
    private PersonInformationReport personInformationReportByPersonInformationReportId;
    private String dateTime;
    private CrewAccepted crewAcceptedByCrewAcceptedId;


    public ReceivedCall() {
    }

    public ReceivedCall(final Integer id, final Description descriptionByDescriptionId, final String address, final PersonInformationReport personInformationReportByPersonInformationReportId, final String dateTime, final CrewAccepted crewAcceptedByCrewAcceptedId) {
        this.id = id;
        this.descriptionByDescriptionId = descriptionByDescriptionId;
        this.address = address;
        this.personInformationReportByPersonInformationReportId = personInformationReportByPersonInformationReportId;
        this.dateTime = dateTime;
        this.crewAcceptedByCrewAcceptedId = crewAcceptedByCrewAcceptedId;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "datetime")
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    @JoinColumn(name = "description_id", referencedColumnName = "id", nullable = false)
    public Description getDescriptionByDescriptionId() {
        return descriptionByDescriptionId;
    }

    public void setDescriptionByDescriptionId(Description descriptionByDescriptionId) {
        this.descriptionByDescriptionId = descriptionByDescriptionId;
    }

    @ManyToOne
    @JoinColumn(name = "person_information_report_id", referencedColumnName = "id", nullable = false)
    public PersonInformationReport getPersonInformationReportByPersonInformationReportId() {
        return personInformationReportByPersonInformationReportId;
    }

    public void setPersonInformationReportByPersonInformationReportId(PersonInformationReport personInformationReportByPersonInformationReportId) {
        this.personInformationReportByPersonInformationReportId = personInformationReportByPersonInformationReportId;
    }

    @ManyToOne
    @JoinColumn(name = "crew_accepted_id", referencedColumnName = "id", nullable = false)
    public CrewAccepted getCrewAcceptedByCrewAcceptedId() {
        return crewAcceptedByCrewAcceptedId;
    }

    public void setCrewAcceptedByCrewAcceptedId(CrewAccepted crewAcceptedByCrewAcceptedId) {
        this.crewAcceptedByCrewAcceptedId = crewAcceptedByCrewAcceptedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceivedCall that = (ReceivedCall) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(address, that.address) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, dateTime);
    }


    @Override
    public String toString() {
        return "Received Call [id=" + id + ", descriptionByDescriptionId=" + descriptionByDescriptionId + ", address=" + address + ", personInformationReportByPersonInformationReportId=" + personInformationReportByPersonInformationReportId + ", dateTime=" + dateTime +  ", crewAcceptedByCrewAcceptedId=" + crewAcceptedByCrewAcceptedId + "]";
    }
}
