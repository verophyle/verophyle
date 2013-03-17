/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.gae.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * GIN module with bindings for the GAE GWT module.
 */
public class VerophyleGinModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(VerophyleLogger.class).in(Singleton.class);
  }

}
