/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.domain.CoreEntity;
import com.verophyle.core.server.domain.Identity;

public abstract class CoreObjectifyService  {

  protected CoreObjectifyService() {
    register(CoreEntity.class);
    register(Identity.class);
  }
  
  protected abstract void register(Class<? extends CoreEntity> clazz);
  
  public abstract Objectify ofy();
  
}
