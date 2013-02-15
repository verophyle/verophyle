package com.verophyle.core.shared.rf.identity;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.verophyle.core.server.rf.CoreServiceLocator;
import com.verophyle.core.server.rf.identity.IdentityService;

@Service(value = IdentityService.class, locator = CoreServiceLocator.class)
public interface IdentityRequest extends RequestContext {
	Request<IdentityProxy> getCurrentIdentity();
	Request<String> getGravatarImageUrl(IdentityProxy identity);
	
	Request<String> getLoginUrl(String currentUrl);
	Request<String> getLogoutUrl(String currentUrl);
}
