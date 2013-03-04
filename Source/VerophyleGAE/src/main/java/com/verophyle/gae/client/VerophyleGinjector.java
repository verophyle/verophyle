/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.gae.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * GIN injector for the GAE module.
 */
@GinModules({VerophyleGinModule.class})
public interface VerophyleGinjector extends Ginjector {
  /**
   * Static instance of the injector.
   */
  VerophyleGinjector INSTANCE = GWT.create(VerophyleGinjector.class);
  
  /**
   * Gets the client-side logger.
   */
  VerophyleLogger getVerophyleLogger();
}
