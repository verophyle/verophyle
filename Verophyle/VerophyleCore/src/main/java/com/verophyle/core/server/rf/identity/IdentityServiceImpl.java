package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUser;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.domain.Identity;

public class IdentityServiceImpl implements IdentityService {

	private final CoreUserService userService;
	private final CoreObjectifyService objectifyService;
	
	@Inject
	public IdentityServiceImpl(CoreUserService userService, CoreObjectifyService objectifyService) {
		this.userService = userService;
		this.objectifyService = objectifyService;
	}
	
	@Override
	public Identity getCurrentIdentity() {
		Objectify ofy = objectifyService.ofy();
		
		// get current user, if any
		CoreUser currentUser;
		if (userService.isUserLoggedIn() && (currentUser = userService.getCurrentUser()) != null) {
			Identity identity = ofy.load().type(Identity.class).filter("handle =", currentUser.getNickname()).first().get();
			
			if (identity == null) {
				// create new identity for this user
				identity = new Identity();
				identity.setHandle(currentUser.getNickname());
				ofy.save().entity(identity).now();
			}

			return identity;
		}

		// get or create guest user
		Identity guest = ofy.load().type(Identity.class).filter("handle =", Identity.GUEST_HANDLE).first().get();
		
		if (guest == null) {
			guest = new Identity();
			guest.setHandle(Identity.GUEST_HANDLE);
			
			guest.setAnonymous(true);
			ofy.save().entity(guest).now();
		}
		
		return guest;
	}

	@Override
	public String getLoginUrl(String currentUrl) {
		return userService.createLoginUrl(currentUrl);
	}

	@Override
	public String getLogoutUrl(String currentUrl) {
		return userService.createLogoutUrl(currentUrl);
	}
	
}
