package com.verophyle.core.shared.rf;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.server.rf.CoreUserLocator;

@ProxyFor(value = CoreUser.class, locator=CoreUserLocator.class)
public interface CoreUserProxy extends CoreEntityProxy {
  public String getEmail();
}
