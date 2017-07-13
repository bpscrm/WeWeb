/**
 * 
 */
package com.bp.wei.model;

import java.util.Arrays;

/**
 * @author liyanc
 * @date 2017-07-01
 */
public class ComboButton extends Button{
	
	private Button[] sub_button;	

	public Button[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(Button[] sub_Button) {
		this.sub_button = sub_Button;
	}

	@Override
	public String toString() {
		return "ComboButton [name=" + this.getName() + ", [subButton=" + Arrays.toString(sub_button) + "]";
	}	
	
}
