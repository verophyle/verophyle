/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity;

import java.util.HashMap;
import java.util.logging.Level;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;

/**
 * Core implementation of the activity registry.
 * @param <A> Activity class.
 * @param <P> Place class.
 */
public class CoreActivityRegistryImpl<A extends CoreActivity, P extends CorePlace> implements CoreActivityRegistry<A, P> {
  
  private final HashMap<String, Provider<? extends CoreActivityProxy<? extends A, ? extends P>>> providers = 
      new HashMap<String, Provider<? extends CoreActivityProxy<? extends A, ? extends P>>>();
  
  private CoreLogger logger;
  
  @Inject
  public CoreActivityRegistryImpl(CoreLogger logger) throws Exception {
    this.logger = logger;
  }
  
  /**
   * Register an activity provider.
   */
  public void register(String placeKey, Provider<? extends CoreActivityProxy<? extends A, ? extends P>> provider) {
    logger.log(Level.INFO, "ContentActivityRegistry.register(\"" + placeKey + "\", ...)");
    providers.put(placeKey, provider);
  }
  
  /**
   * Get an activity provider.
   */
  public Provider<? extends CoreActivityProxy<? extends A, ? extends P>> getProvider(String placeKey) {
    return providers.get(placeKey);
  }
  
}
