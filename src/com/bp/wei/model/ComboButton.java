/**
 * 
 */
package com.bp.wei.model;

import java.util.Arrays;

/**
 * @author liyanc
 * @date 2017-07-01
 */
public class ComboButton extends Button {
	private Button[] subButton;

	public Button[] getSubButton() {
		return subButton;
	}

	public void setSubButton(Button[] subButton) {
		this.subButton = subButton;
	}

	@Override
	public String toString() {
		return "ComboButton [key=" + getKey() + ", name=" + this.getName() + ", type=" + this.getKey() + ", [subButton=" + Arrays.toString(subButton) + "]";
	}	
	
}
