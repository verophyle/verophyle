package com.verophyle.gae.server;

import com.google.appengine.api.users.User;
import com.google.inject.Inject;
import com.verophyle.core.server.CoreUser;

public class GaeUser implements CoreUser {

	private final User user;
	
	@Inject
	public GaeUser(User user) {
		assert user != null;		
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

}
