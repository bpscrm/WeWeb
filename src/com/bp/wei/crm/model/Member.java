package com.bp.wei.crm.model;

import java.util.List;

public class Member {
	
	private String id;
	
	private String name;
	
	private String mobile;
	
	private String gender;
	
	private String birthday;
	
	//private List<Childinfo> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	

	//public List<Childinfo> getChildren() {
	//	return children;
	//}

	//public void setChildren(List<Childinfo> children) {
	//	this.children = children;
	//}

	//@Override
	//public String toString() {
	//	return "Member [id=" + id + ", name=" + name + ", mobile=" + mobile + ", gender=" + gender + ", birthday="
	//			+ birthday + ", children=" + children + "]";
	//}
	
}
