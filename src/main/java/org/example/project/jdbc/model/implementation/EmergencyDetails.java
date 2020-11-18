package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class EmergencyDetails implements GeneralModelInterface {
    private Integer id;
    private String type;
    private String cause;

    public EmergencyDetails(Integer id, String type, String cause) {
        this.id = id;
        this.type = type;
        this.cause = cause;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "EmergencyDetails{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
