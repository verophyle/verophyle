/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class CoreExceptionHandler implements ExceptionHandler {
  @Inject
  public CoreExceptionHandler() {
    super();
  }
  
  @Override
  public ServerFailure createServerFailure(Throwable throwable) {
    return new ServerFailure(throwable.getMessage(), throwable.getClass().getName(), null, true);
  }
}