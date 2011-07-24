package com.verophyle.kernel.shared;

public class TestServiceValidate {

	public static boolean isValidName(String name) {
		return name != null && name.length() > 3;
	}
	
}
