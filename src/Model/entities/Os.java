package Model.entities;

import Model.entities.enums.OsStatus;
import Model.entities.enums.Payments;

import java.util.ArrayList;
import java.util.Date;

public class Os {
    private String osId;
    private String description;
    private Date startTime;
    private Date endTime;
    private Double totalValue;
    private String duration;
    private OsStatus status;
    private Payments typePayment;
    private Integer installments;
    private String attendantId;
    private String technicianId;
    private String clientId;
    private ArrayList<Product> usedParts;

    public Os(String osId, String description, Date startTime, Date endTime, Double totalValue, String duration,
              OsStatus status, Payments typePayment, Integer installments, String attendantId, String technicianId,
              String clientId, ArrayList<Product> usedParts) {
        this.osId = osId;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalValue = totalValue;
        this.duration = duration;
        this.status = status;
        this.typePayment = typePayment;
        this.installments = installments;
        this.attendantId = attendantId;
        this.technicianId = technicianId;
        this.clientId = clientId;
        this.usedParts = usedParts;
    }

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public OsStatus getStatus() {
        return status;
    }

    public void setStatus(OsStatus status) {
        this.status = status;
    }

    public Payments getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(Payments typePayment) {
        this.typePayment = typePayment;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(String attendantId) {
        this.attendantId = attendantId;
    }

    public String getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ArrayList<Product> getUsedParts() {
        return usedParts;
    }

    public void setUsedParts(ArrayList<Product> usedParts) {
        this.usedParts = usedParts;
    }
}
