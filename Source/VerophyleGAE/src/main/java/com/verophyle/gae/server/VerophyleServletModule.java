/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.gae.server;

import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.rf.CoreRequestFactoryServlet;

/**
 * Guice servlet module for the GAE GWT module.
 */
public class VerophyleServletModule extends ServletModule {
  
  @Inject
  public VerophyleServletModule() {
    super();
  }

  @Override
  protected void configureServlets() {
    bind(RemoteLoggingServiceImpl.class).in(Singleton.class);
    bind(CoreRequestFactoryServlet.class).in(Singleton.class);
    
    serve("/Verophyle/remote_logging").with(RemoteLoggingServiceImpl.class);
    serve("/gwtRequest").with(CoreRequestFactoryServlet.class);    
  }
  
  /**
   * Gets the user service.
   * @param objectifyService Objectify service.
   */
  @Provides
  @Singleton
  public CoreUserService getUserService(CoreObjectifyService objectifyService) {
    return new GaeUserService(UserServiceFactory.getUserService(), objectifyService);
  }

  /**
   * Gets the Objectify service.
   */
  @Provides
  @Singleton
  public CoreObjectifyService getObjectifyService() {
    return new GaeObjectifyService();
  }
  
}
