/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;

public class CoreRequestFactoryServlet extends RequestFactoryServlet {
  
  private static final long serialVersionUID = 2556778857221892203L;
  
  @Inject
  public CoreRequestFactoryServlet(final ExceptionHandler exceptionHandler, final ServiceLayerDecorator serviceLayerDecorator) {
    super(exceptionHandler, serviceLayerDecorator);
  }
  
}
