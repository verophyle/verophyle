package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Ref;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.server.domain.Identity;
import com.verophyle.core.shared.Gravatar;

public class IdentityServiceImpl implements IdentityService {

	private final CoreUserService userService;
	private final CoreObjectifyService objectifyService;
	
	@Inject
	public IdentityServiceImpl(CoreUserService userService, CoreObjectifyService objectifyService) {
		this.userService = userService;
		this.objectifyService = objectifyService;
	}
	
	@Override
	public synchronized Identity getCurrentIdentity() {
		Objectify ofy = objectifyService.ofy();
		
		// get current user
		CoreUser currentUser;
		if (userService.isUserLoggedIn() && (currentUser = userService.getCurrentUser()) != null) {
			// search for identities with that user's handle
			for (Identity identity : ofy.load().type(Identity.class).filter("handle =", currentUser.getNickname())) {
				// see if any of the identity's users is the current one
				for (Ref<CoreUser> coreUser : identity.getUsers()) {
					if (coreUser.get().getUserId().equals(currentUser.getUserId())) {
						return identity;
					}
				}
			}
			
			// no existing identity found; create new identity for this user
			String nickname = currentUser.getNickname();
			if (nickname.equals(Identity.GUEST_HANDLE))
				nickname = nickname + " n00b";
			
			Identity identity = new Identity();
			identity.setHandle(currentUser.getNickname());
			identity.getUsers().add(Ref.create(currentUser));
				
			ofy.save().entity(identity).now();

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
	public String getGravatarImageUrl(Identity identity) {
		if (identity == null)
			return null;
		
		for (Ref<CoreUser> coreUser : identity.getUsers()) {
			String email = coreUser.get().getEmail();
			if (email != null && !email.isEmpty())
				return makeGravatarImageUrl(email);
		}
		
		return makeGravatarImageUrl("anonymous@verophyle.com");
	}

	private String makeGravatarImageUrl(String email) {
		return "http://www.gravatar.com/avatar/" + Gravatar.getHash(email) + "?r=g";
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
