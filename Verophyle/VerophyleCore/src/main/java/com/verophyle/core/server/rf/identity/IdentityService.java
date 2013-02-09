package com.verophyle.core.server.rf.identity;

import com.verophyle.core.server.domain.Identity;

public interface IdentityService {
	Identity getCurrentIdentity();	
	String getLoginUrl(String currentUrl);
	String getLogoutUrl(String currentUrl);
}
