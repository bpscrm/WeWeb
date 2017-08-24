package com.bp.wei.model;

public class CommonButton extends Button {
	private String key;
	
	private String type;
	
	private String url;

	public String getKey() {
		return key;
	}

	public void setKey(String id) {
		System.out.println( "[model][CommonButton][setKey]" + id);
		this.key = id;
	}

	public String getType() {
		System.out.println( "[model][CommonButton][getType]" + type);
		return type;
	}

	public void setType(String type) {
		System.out.println( "[model][CommonButton][setType]" + type);
		this.type = type;
	}	

	public String getUrl() {
		System.out.println( "[model][CommonButton][getUrl]" + url);
		return url;
	}

	public void setUrl(String url) {
		System.out.println( "[model][CommonButton][setUrl]" + url);
		this.url = url;
	}

	@Override
	public String toString() {
		System.out.println( "[model][CommonButton][toString]");
		return "CommonButton [key=" + key + ", type=" + type + ", url=" + url + ", toString()=" + super.toString()
				+ "]";
	}	
	
}