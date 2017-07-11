/**
 * 
 */
package com.bp.wei.model;

import java.util.Arrays;

/**
 * @author liyanc
 * @date 2017-07-01
 */
public class ComboButton {
	private String name;
	
	private Button[] subButton;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Button[] getSubButton() {
		return subButton;
	}

	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}

	@Override
	public String toString() {
		return "ComboButton [name=" + this.getName() + ", [subButton=" + Arrays.toString(subButton) + "]";
	}	
	
}
