package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.EntitySubclass;
import com.googlecode.objectify.annotation.Index;

@EntitySubclass(index = true)
public class Identity extends CoreEntity {
	
	public static final String GUEST_HANDLE = "Anonymous";

	@Index
	String handle;
	
	boolean anonymous;
	boolean administrator;
	
	public Identity() {
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	public boolean isAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	
	public boolean isAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	
}
