/**
 * 
 */
package com.bp.wei.model;

/**
 * @author liyanc
 * @date 2017-07-01
 */
public class Button {
	
	private String name;
	
	public String getName() {
		System.out.println( "[Button][getName]");
		return name;
	}

	public void setName(String name) {
		System.out.println( "[Button][setName]");
		this.name = name;
	}	

	@Override
	public String toString() {
		System.out.println( "[Button][toString]");
		return "Button [name=" + name + "]";
	}		
	
}
