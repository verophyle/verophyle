package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.domain.AuthIdentityResult;
import com.verophyle.core.server.rf.CoreLocator;

public class AuthIdentityResultLocator extends CoreLocator<AuthIdentityResult> {

  @Inject
  public AuthIdentityResultLocator(Injector injector) {
    super(injector, AuthIdentityResult.class);
  }

}
