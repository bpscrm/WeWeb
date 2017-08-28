package com.bp.wei.crm.model;

import java.util.Date;

public class ParticipateData {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private String particDataType;

    private String particDataSignup;

    private String particDataRegister;

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

    public String getParticDataType() {
        return particDataType;
    }

    public void setParticDataType(String particDataType) {
        this.particDataType = particDataType == null ? null : particDataType.trim();
    }

    public String getParticDataSignup() {
        return particDataSignup;
    }

    public void setParticDataSignup(String particDataSignup) {
        this.particDataSignup = particDataSignup == null ? null : particDataSignup.trim();
    }

    public String getParticDataRegister() {
        return particDataRegister;
    }

    public void setParticDataRegister(String particDataRegister) {
        this.particDataRegister = particDataRegister == null ? null : particDataRegister.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}