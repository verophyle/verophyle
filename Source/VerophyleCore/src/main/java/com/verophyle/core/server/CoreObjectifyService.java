/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.domain.Capability;
import com.verophyle.core.server.domain.CoreEntity;
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.server.domain.Identity;

public abstract class CoreObjectifyService  {

  protected CoreObjectifyService() {
    register(CoreUser.class);
    register(Identity.class);
    register(Capability.class);
  }
  
  protected abstract void register(Class<? extends CoreEntity> clazz);
  
  public abstract Objectify ofy();
  
}
