package com.bp.wei.crm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Purchaseinfo {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private BigDecimal purchasePrice;

    private String purchaseStDt;

    private String purchaseEdDt;

    private String purchaseSt;

    private String description;
    
    private List<Feedback> feedback;
    
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseStDt() {
        return purchaseStDt;
    }

    public void setPurchaseStDt(String purchaseStDt) {
        this.purchaseStDt = purchaseStDt;
    }

    public String getPurchaseEdDt() {
        return purchaseEdDt;
    }

    public void setPurchaseEdDt(String purchaseEdDt) {
        this.purchaseEdDt = purchaseEdDt;
    }

    public String getPurchaseSt() {
        return purchaseSt;
    }

    public void setPurchaseSt(String purchaseSt) {
        this.purchaseSt = purchaseSt == null ? null : purchaseSt.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
  
	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
}