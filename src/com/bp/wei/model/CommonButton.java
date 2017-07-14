package com.bp.wei.model;

public class CommonButton extends Button {
	private String key;
	
	private String type;
	
	private String url;

	public String getKey() {
		return key;
	}

	public void setKey(String id) {
		this.key = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "CommonButton [key=" + key + ", type=" + type + ", url=" + url + ", toString()=" + super.toString()
				+ "]";
	}	
	
}
