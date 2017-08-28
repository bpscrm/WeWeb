package com.bp.wei.crm.model;

import java.util.Date;
import java.util.List;

public class Question {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private String interacSt;

    private String description;
    
    private List<AnswerOption> options;

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

    public String getInteracSt() {
        return interacSt;
    }

    public void setInteracSt(String interacSt) {
        this.interacSt = interacSt == null ? null : interacSt.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public List<AnswerOption> getOptions() {
		return options;
	}

	public void setOptions(List<AnswerOption> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", dateEntered=" + dateEntered + ", dateModified="
				+ dateModified + ", modifiedUserId=" + modifiedUserId + ", createdBy=" + createdBy + ", deleted="
				+ deleted + ", assignedUserId=" + assignedUserId + ", interacSt=" + interacSt + ", description="
				+ description + ", options=" + options + "]";
	}    
    
}