package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.verophyle.core.server.CoreUser;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.shared.domain.Identity;

public class IdentityServiceImpl implements IdentityService {

	private final CoreUserService userService;
	
	@Inject
	public IdentityServiceImpl(CoreUserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Identity getCurrentUser() {
		// get current user
		if (userService.isUserLoggedIn()) {
			CoreUser currentUser = userService.getCurrentUser();
			
		} else {
			
		}
		
		// give up
		return null;
	}

}
