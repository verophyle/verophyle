package com.verophyle.core.server;

import java.util.Set;

public interface CoreUserService {
	String createLoginUrl(String destinationUrl);
	String createLoginUrl(String destinationUrl, String authDomain);
	String createLoginUrl(String destinationUrl, String authDomain, String federatedIdentity, Set<String> attributesRequest);
	String createLogoutUrl(String destinationUrl);
	String createLogoutUrl(String destinationUrl, String authDomain);
	CoreUser getCurrentUser();
	boolean isUserAdmin();
	boolean isUserLoggedIn();
}
