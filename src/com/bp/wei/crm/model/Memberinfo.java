package com.bp.wei.crm.model;

import java.util.List;

public class Memberinfo {
    private String id;

    private String name;

    private String dateEntered;

    private String dateModified;

    private String modifiedUserId;

    private String createdBy;

    private Boolean deleted;

    private String assignedUserId;

    private String mbPassword;

    private String mbTitle;

    private String mbName;

    private String mbBirthday;

    private String mbChild;

    private String mbEdu;
    
    //private List<Childinfo> children;
    
    //private List<Purchaseinfo> purchase;

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

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
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

    public String getMbPassword() {
        return mbPassword;
    }

    public void setMbPassword(String mbPassword) {
        this.mbPassword = mbPassword == null ? null : mbPassword.trim();
    }

    public String getMbTitle() {
        return mbTitle;
    }

    public void setMbTitle(String mbTitle) {
        this.mbTitle = mbTitle == null ? null : mbTitle.trim();
    }

    public String getMbName() {
        return mbName;
    }

    public void setMbName(String mbName) {
        this.mbName = mbName == null ? null : mbName.trim();
    }

    public String getMbBirthday() {
        return mbBirthday;
    }

    public void setMbBirthday(String mbBirthday) {
        this.mbBirthday = mbBirthday;
    }

    public String getMbChild() {
        return mbChild;
    }

    public void setMbChild(String mbChild) {
        this.mbChild = mbChild == null ? null : mbChild.trim();
    }

    public String getMbEdu() {
        return mbEdu;
    }

    public void setMbEdu(String mbEdu) {
        this.mbEdu = mbEdu == null ? null : mbEdu.trim();
    }
    
	//public List<Childinfo> getChildren() {
	//	return children;
	//}

	//public void setChildren(List<Childinfo> children) {
	//	this.children = children;
	//}
	
	//public List<Purchaseinfo> getPurchase() {
	//	return purchase;
	//}

	//public void setPurchase(List<Purchaseinfo> purchase) {
	//	this.purchase = purchase;
	//}
}