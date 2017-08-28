package com.bp.wei.crm.model;

import java.math.BigDecimal;
import java.util.Date;

public class Participate {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private BigDecimal particFee;

    private Date particStDt;

    private Date particEdDt;

    private String partictSt;

    private String particType;

    private String particCode;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId == null ? null : modifiedUserId.trim();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId == null ? null : assignedUserId.trim();
    }

    public BigDecimal getParticFee() {
        return particFee;
    }

    public void setParticFee(BigDecimal particFee) {
        this.particFee = particFee;
    }

    public Date getParticStDt() {
        return particStDt;
    }

    public void setParticStDt(Date particStDt) {
        this.particStDt = particStDt;
    }

    public Date getParticEdDt() {
        return particEdDt;
    }

    public void setParticEdDt(Date particEdDt) {
        this.particEdDt = particEdDt;
    }

    public String getPartictSt() {
        return partictSt;
    }

    public void setPartictSt(String partictSt) {
        this.partictSt = partictSt == null ? null : partictSt.trim();
    }

    public String getParticType() {
        return particType;
    }

    public void setParticType(String particType) {
        this.particType = particType == null ? null : particType.trim();
    }

    public String getParticCode() {
        return particCode;
    }

    public void setParticCode(String particCode) {
        this.particCode = particCode == null ? null : particCode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}