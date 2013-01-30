package com.verophyle.core.shared.domain;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Identity extends CoreEntity<Long> {

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
