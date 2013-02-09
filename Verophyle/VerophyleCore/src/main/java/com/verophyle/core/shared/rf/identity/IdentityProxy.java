package com.verophyle.core.shared.rf.identity;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.server.domain.Identity;
import com.verophyle.core.server.rf.identity.IdentityLocater;
import com.verophyle.core.shared.rf.CoreEntityProxy;

@ProxyFor(value = Identity.class, locator = IdentityLocater.class)
public interface IdentityProxy extends CoreEntityProxy {
	String getHandle();
	void setHandle(String handle);
	
	boolean isAnonymous();
	boolean isAdministrator();
}
