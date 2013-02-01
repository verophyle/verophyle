package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.core.shared.domain.Identity;

public class IdentityLocater extends CoreLocator<Identity> {

	@Inject
	public IdentityLocater(Injector injector) {
		super(injector, Identity.class);
	}

}
