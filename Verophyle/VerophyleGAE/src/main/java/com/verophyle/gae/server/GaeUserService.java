package com.verophyle.gae.server;

import java.util.Set;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.verophyle.core.server.CoreUser;
import com.verophyle.core.server.CoreUserService;

public class GaeUserService implements CoreUserService {
	
	private final UserService userService;

	public GaeUserService(UserService userService) {
		assert userService != null;
		this.userService = userService;
	}
	
	@Override
	public String createLoginUrl(String destinationUrl) {
		return userService.createLoginURL(destinationUrl);
	}

	@Override
	public String createLoginUrl(String destinationUrl, String authDomain) {
		return userService.createLoginURL(destinationUrl, authDomain);
	}

	@Override
	public String createLoginUrl(String destinationUrl, String authDomain, String federatedIdentity, Set<String> attributesRequest) {
		return userService.createLoginURL(destinationUrl, authDomain, federatedIdentity, attributesRequest);
	}

	@Override
	public String createLogoutUrl(String destinationUrl) {
		return userService.createLogoutURL(destinationUrl);
	}

	@Override
	public String createLogoutUrl(String destinationUrl, String authDomain) {
		return userService.createLogoutURL(destinationUrl, authDomain);
	}

	@Override
	public CoreUser getCurrentUser() {
		User currentUser = userService.getCurrentUser();
		return currentUser != null ? new GaeUser(currentUser) : null;
	}

	@Override
	public boolean isUserAdmin() {
		return userService.isUserAdmin();
	}

	@Override
	public boolean isUserLoggedIn() {
		return userService.isUserLoggedIn();
	}
	
}
