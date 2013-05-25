/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.shared.rf;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.server.rf.CoreUserLocator;

@ProxyFor(value = CoreUser.class, locator = CoreUserLocator.class)
public interface CoreUserProxy extends EntityProxy {
  Long getId();
  public String getEmail();
}
