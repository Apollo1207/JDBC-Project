package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

public class ReceivedCallHasCrewAccepted implements GeneralModelInterface {
    private Integer receivedCallId;
    private Integer crewAcceptedId;

    public ReceivedCallHasCrewAccepted(Integer receivedCallId, Integer crewAcceptedId) {
        this.receivedCallId = receivedCallId;
        this.crewAcceptedId = crewAcceptedId;
    }

    public Integer getReceivedCallId() {
        return receivedCallId;
    }

    public void setReceivedCallId(Integer receivedCallId) {
        this.receivedCallId = receivedCallId;
    }

    public Integer getCrewAcceptedId() {
        return crewAcceptedId;
    }

    public void setCrewAcceptedId(Integer crewAcceptedId) {
        this.crewAcceptedId = crewAcceptedId;
    }

    @Override
    public String toString() {
        return "ReceivedCallHasCrewAccepted{" +
                "receivedCallId=" + receivedCallId +
                ", crewAcceptedId=" + crewAcceptedId +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
