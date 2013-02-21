/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.server.rf.identity;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.domain.Identity;
import com.verophyle.core.server.rf.CoreLocator;

public class IdentityLocater extends CoreLocator<Identity> {

  @Inject
  public IdentityLocater(Injector injector) {
    super(injector, Identity.class);
  }

}
