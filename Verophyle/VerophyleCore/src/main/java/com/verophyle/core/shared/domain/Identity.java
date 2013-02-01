package com.verophyle.core.shared.domain;

import com.googlecode.objectify.annotation.EntitySubclass;

@EntitySubclass(index = true)
public class Identity extends CoreEntity {
	
	public static final String GUEST_HANDLE = "Anonymous";

	private String handle;
	
	public Identity() {
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
}
