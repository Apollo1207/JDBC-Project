package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class CrewAccepted implements GeneralModelInterface {
    private Integer id;
    private Integer number;
    private String numberOfCar;
    private String typeOfCar;
    private String depatureTime;
    private String arriveTime;

    public CrewAccepted(Integer id, Integer number, String numberOfCar, String typeOfCar, String depatureTime, String arriveTime) {
        this.id = id;
        this.number = number;
        this.numberOfCar = numberOfCar;
        this.typeOfCar = typeOfCar;
        this.depatureTime = depatureTime;
        this.arriveTime = arriveTime;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(String numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getDepatureTime() {
        return depatureTime;
    }

    public void setDepatureTime(String depatureTime) {
        this.depatureTime = depatureTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    @Override
    public String toString() {
        return "CrewAccepted{" +
                "id=" + id +
                ", number=" + number +
                ", numberOfCar='" + numberOfCar + '\'' +
                ", typeOfCar='" + typeOfCar + '\'' +
                ", depatureTime='" + depatureTime + '\'' +
                ", arriveTime='" + arriveTime + '\'' +
                '}';
    }
}
