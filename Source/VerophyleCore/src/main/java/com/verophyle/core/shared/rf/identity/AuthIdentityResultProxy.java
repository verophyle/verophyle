package com.verophyle.core.shared.rf.identity;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.server.domain.AuthIdentityResult;
import com.verophyle.core.server.rf.identity.AuthIdentityResultLocator;
import com.verophyle.core.shared.AuthAction;
import com.verophyle.core.shared.AuthResult;

@ProxyFor(value = AuthIdentityResult.class, locator = AuthIdentityResultLocator.class)
public interface AuthIdentityResultProxy extends EntityProxy {
  public AuthAction getAction();
  public AuthResult getResult();
  public IdentityProxy getIdentity();
}
