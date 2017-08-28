package com.bp.wei.crm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Marketinginfo {
    private String id;

    private String name;

    private Date dateEntered;

    private Date dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private Date stDt;

    private Date edDt;

    private String marketSt;

    private BigDecimal marketFee;
    
    private List<Marketinginfo> marketinglist;

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

    public Date getStDt() {
        return stDt;
    }

    public void setStDt(Date stDt) {
        this.stDt = stDt;
    }

    public Date getEdDt() {
        return edDt;
    }

    public void setEdDt(Date edDt) {
        this.edDt = edDt;
    }

    public String getMarketSt() {
        return marketSt;
    }

    public void setMarketSt(String marketSt) {
        this.marketSt = marketSt == null ? null : marketSt.trim();
    }

    public BigDecimal getMarketFee() {
        return marketFee;
    }

    public void setMarketFee(BigDecimal marketFee) {
        this.marketFee = marketFee;
    }
    
 	public List<Marketinginfo> getMarketinglist() {
 		return marketinglist;
}

 	public void setMarketinglist(List<Marketinginfo> marketinglist) {
 		this.marketinglist = marketinglist;
}     
}