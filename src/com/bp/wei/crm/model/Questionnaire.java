package com.bp.wei.crm.model;

import java.util.Date;
import java.util.List;

public class Questionnaire {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private Date intStDt;

    private Date intEdDt;

    private String intSt;

    private String description;
    
    private List<Question> questions;

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

    public Date getIntStDt() {
        return intStDt;
    }

    public void setIntStDt(Date intStDt) {
        this.intStDt = intStDt;
    }

    public Date getIntEdDt() {
        return intEdDt;
    }

    public void setIntEdDt(Date intEdDt) {
        this.intEdDt = intEdDt;
    }

    public String getIntSt() {
        return intSt;
    }

    public void setIntSt(String intSt) {
        this.intSt = intSt == null ? null : intSt.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questionnaire [id=" + id + ", name=" + name + ", dateEntered=" + dateEntered + ", dateModified="
				+ dateModified + ", modifiedUserId=" + modifiedUserId + ", createdBy=" + createdBy + ", deleted="
				+ deleted + ", assignedUserId=" + assignedUserId + ", intStDt=" + intStDt + ", intEdDt=" + intEdDt
				+ ", intSt=" + intSt + ", description=" + description + ", questions=" + questions + "]";
	}    
    
}