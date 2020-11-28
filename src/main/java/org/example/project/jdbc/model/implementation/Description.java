package org.example.project.jdbc.model.implementation;

import org.example.project.jdbc.model.GeneralModelInterface;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Description implements GeneralModelInterface {
    private Integer id;
    private String shortDesc;
    private String expandedDesc;
    private EmergencyDetails emergencyDetailsByEmergencyDetailsId;
    private Collection<ReceivedCall> receivedCallsById;

    public Description() {
    }

    public Description(Integer id, String shortDesc, String expandedDesc, EmergencyDetails emergencyDetailsByEmergencyDetailsId) {
        this.id = id;
        this.shortDesc = shortDesc;
        this.expandedDesc = expandedDesc;
        this.emergencyDetailsByEmergencyDetailsId = emergencyDetailsByEmergencyDetailsId;
    }

    public Description(final Integer id, final String shortDesc, final String expandedDesc, final EmergencyDetails emergencyDetailsByEmergencyDetailsId, final Collection<ReceivedCall> receivedCallsById) {
        this.id = id;
        this.shortDesc = shortDesc;
        this.expandedDesc = expandedDesc;
        this.emergencyDetailsByEmergencyDetailsId = emergencyDetailsByEmergencyDetailsId;
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
    @Column(name = "short_desc")
    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    @Basic
    @Column(name = "expanded_desc")
    public String getExpandedDesc() {
        return expandedDesc;
    }

    public void setExpandedDesc(String expandedDesc) {
        this.expandedDesc = expandedDesc;
    }


    @ManyToOne
    @JoinColumn(name = "emergency_details_id", referencedColumnName = "id", nullable = false)
    public EmergencyDetails getEmergencyDetailsByEmergencyDetailsId() {
        return emergencyDetailsByEmergencyDetailsId;
    }

    public void setEmergencyDetailsByEmergencyDetailsId(EmergencyDetails emergencyDetailsByEmergencyDetailsId) {
        this.emergencyDetailsByEmergencyDetailsId = emergencyDetailsByEmergencyDetailsId;
    }

    @OneToMany(mappedBy = "descriptionByDescriptionId")
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
        Description that = (Description) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(shortDesc, that.shortDesc) &&
                Objects.equals(expandedDesc, that.expandedDesc) &&
                Objects.equals(emergencyDetailsByEmergencyDetailsId, that.emergencyDetailsByEmergencyDetailsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortDesc, expandedDesc, emergencyDetailsByEmergencyDetailsId);
    }



    @Override
    public String toString() {
        return "Description [id=" + id + ", shortDesc=" + shortDesc + ", expandedDesc=" + expandedDesc + ", emergencyDetailsByEmergencyDetailsId=" + emergencyDetailsByEmergencyDetailsId + "]";
    }

}
