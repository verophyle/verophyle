package com.verophyle.core.server.domain;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.EntitySubclass;
import com.googlecode.objectify.annotation.Index;

@EntitySubclass(index = true)
public class Identity extends CoreEntity {
	
	public static final String GUEST_HANDLE = "Anonymous";

	@Index
	String handle;
	
	List<Ref<CoreUser>> users = new ArrayList<Ref<CoreUser>>();
	
	boolean anonymous;
	
	public Identity() {
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	public List<Ref<CoreUser>> getUsers() {
		return users;
	}
		
	public boolean isAnonymous() {
		return anonymous;
	}
	
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
		
}
