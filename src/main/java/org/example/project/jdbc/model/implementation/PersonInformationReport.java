package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "person_information_report", schema = "fedyniak_illya_db", catalog = "")
public class PersonInformationReport implements GeneralModelInterface {
    private Integer id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Collection<ReceivedCall> receivedCallsById;

    public PersonInformationReport() {
    }

    public PersonInformationReport(Integer id, String name, String lastName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public PersonInformationReport(final Integer id, final String name, final String lastName, final String phoneNumber, final Collection<ReceivedCall> receivedCallsById) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.receivedCallsById = receivedCallsById;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "personInformationReportByPersonInformationReportId")
    public Collection<ReceivedCall> getReceivedCallsById() {
        return receivedCallsById;
    }

    public void setReceivedCallsById(Collection<ReceivedCall> receivedCallsById) {
        this.receivedCallsById = receivedCallsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonInformationReport that = (PersonInformationReport) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, phoneNumber);
    }


    @Override
    public String toString() {
        return "Person Information Report [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
    }
}
