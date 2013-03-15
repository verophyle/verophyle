/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class CoreServiceLocatorImpl implements CoreServiceLocator {

  private final Injector injector;
  
  @Inject
  protected CoreServiceLocatorImpl(final Injector injector) {
    super();
    this.injector = injector;
  }
    
  @Override
  public Object getInstance(Class<?> clazz) {
    return injector.getInstance(clazz);
  }

}
