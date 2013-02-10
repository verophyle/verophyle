package com.verophyle.gae.server;

import com.google.appengine.api.users.User;
import com.google.inject.Inject;
import com.googlecode.objectify.annotation.EntitySubclass;
import com.verophyle.core.server.domain.CoreUser;

@EntitySubclass(index = true)
public class GaeUser extends CoreUser {

	User user;
	
	@Inject
	public GaeUser() {
	}
	
	@Inject
	public GaeUser(User user) {
		assert user != null;		
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int compareTo(CoreUser user) {
		if (user instanceof GaeUser) {
			return this.user.compareTo(((GaeUser)user).user);
		}
		throw new RuntimeException("Attempted to compare a GaeUser to a different subclass of CoreUser.");
	}

	@Override
	public String getAuthDomain() {
		return user.getAuthDomain();
	}

	@Override
	public String getEmail() {
		return user.getEmail();
	}

	@Override
	public String getFederatedIdentity() {
		return user.getFederatedIdentity();
	}

	@Override
	public String getNickname() {
		return user.getNickname();
	}

	@Override
	public String getUserId() {
		return user.getUserId();
	}

	@Override
	public int hashCode() {
		return user != null ? user.hashCode() : 0;
	}
	
	@Override
	public String toString() {
		return "GaeUser[" + (user != null ? user.toString() : "<null") + "]";
	}
	
}
