/**
 * 
 */
package com.bp.wei.model;

/**
 * @author liyanc
 * @date 2017-07-01
 */
public class Button {
	
	private String key;
	
	private String name;
	
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "Button [key=" + key + ", name=" + name + ", type=" + type + "]";
	}	
	
}
