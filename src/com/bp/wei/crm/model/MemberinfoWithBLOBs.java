package com.bp.wei.crm.model;

public class MemberinfoWithBLOBs extends Memberinfo {
    private String description;

    private String mbAddr;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getMbAddr() {
        return mbAddr;
    }

    public void setMbAddr(String mbAddr) {
        this.mbAddr = mbAddr == null ? null : mbAddr.trim();
    }
    
}