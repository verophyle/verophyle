package com.verophyle.core.shared.rf;

import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.verophyle.core.shared.rf.identity.IdentityRequest;

public interface CoreRequestFactory extends RequestFactory {
	IdentityRequest identityRequest();
}
