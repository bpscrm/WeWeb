/**
 * 
 */
package com.bp.wei.model;

import java.util.Arrays;

/**
 * @author liyanc
 * @date 2017-07-01
 */

public class Menu {
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	@Override
	public String toString() {
		return "Menu [button=" + Arrays.toString(button) + "]";
	}	
	
}
