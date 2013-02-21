/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.gae.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules({VerophyleGinModule.class})
public interface VerophyleGinjector extends Ginjector {
  VerophyleGinjector INSTANCE = GWT.create(VerophyleGinjector.class);
  
  VerophyleLogger getVerophyleLogger();
}
