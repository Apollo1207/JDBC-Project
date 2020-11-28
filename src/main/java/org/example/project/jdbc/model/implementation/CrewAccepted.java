package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "crew_accepted", schema = "fedyniak_illya_db", catalog = "")
public class CrewAccepted implements GeneralModelInterface {
    private Integer id;
    private String number;
    private String numberOfCar;
    private String typeOfCar;
    private String depatureTime;
    private String arriveTime;
    private Collection<ReceivedCall> receivedCallsById;

    public CrewAccepted() {
    }

    public CrewAccepted(Integer id, String number, String numberOfCar, String typeOfCar, String depatureTime, String arriveTime) {
        this.id = id;
        this.number = number;
        this.numberOfCar = numberOfCar;
        this.typeOfCar = typeOfCar;
        this.depatureTime = depatureTime;
        this.arriveTime = arriveTime;
    }

    public CrewAccepted(final Integer id, final String number, final String numberOfCar, final String typeOfCar, final String depatureTime, final String arriveTime, final Collection<ReceivedCall> receivedCallsById) {
        this.id = id;
        this.number = number;
        this.numberOfCar = numberOfCar;
        this.typeOfCar = typeOfCar;
        this.depatureTime = depatureTime;
        this.arriveTime = arriveTime;
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
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "number_of_car")
    public String getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(String numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    @Basic
    @Column(name = "type_of_car")
    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    @Basic
    @Column(name = "depature_time")
    public String getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

    @Basic
    @Column(name = "arrive_time")
    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }


    @OneToMany(mappedBy = "crewAcceptedByCrewAcceptedId")
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
        CrewAccepted that = (CrewAccepted) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(number, that.number) &&
                Objects.equals(numberOfCar, that.numberOfCar) &&
                Objects.equals(typeOfCar, that.typeOfCar) &&
                Objects.equals(depatureTime, that.depatureTime) &&
                Objects.equals(arriveTime, that.arriveTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, numberOfCar, typeOfCar, depatureTime, arriveTime);
    }


    @Override
    public String toString() {
        return "Crew Accepted [id=" + id + ", number=" + number + ", typeOfCar=" + typeOfCar + ", depatureTime=" + depatureTime + ", arriveTime=" + arriveTime + ", receivedCallsById=" + receivedCallsById + "]";
    }

}
