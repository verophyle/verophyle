/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity;

import java.util.logging.Level;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;

/**
 * Base class for activity mappers.  These take places and map them to the appropriate activities.
 * 
 * Each module will register its activities with the core registry, and then the activity mapper
 * will choose the appropriate activity for each place.
 * 
 * The only reason subclasses of this exist is because of type erasure. 
 * 
 * @param <A> Activity class.
 * @param <P> Place class.
 */
public abstract class CoreActivityMapper<A extends CoreActivity, P extends CorePlace> implements ActivityMapper {  
  private CoreActivityRegistry<A, P> registry;
  private Provider<CoreActivityProxy<A, P>> defaultProvider;
  private CoreLogger logger;
  
  protected CoreActivityMapper(CoreActivityRegistry<A, P> registry, Provider<CoreActivityProxy<A, P>> defaultProvider, CoreLogger logger) {
    this.registry = registry;
    this.defaultProvider = defaultProvider;
    this.logger = logger;
  }
  
  /**
   * Register an activity provider.
   * 
   * This is called by the various Verophyle modules to register their activities.
   * 
   * @param placeKey Place key (i.e. the name of the Place class).
   * @param provider Provider.
   */
  protected void register(String placeKey, Provider<? extends CoreActivityProxy<? extends A, ? extends P>> provider) {
    registry.register(placeKey, provider);
  }
  
  /**
   * Get an activity that corresponds to the given place.
   */
  @Override
  public Activity getActivity(Place place) {
    CorePlace corePlace = place instanceof CorePlace ? (CorePlace)place : null;
    
    if (corePlace != null) {
      Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> provider =
        registry.getProvider(corePlace.getPlaceKey());
      
      if (provider != null) {
        CoreActivityProxy<? extends CoreActivity, ? extends CorePlace> activity =
          provider.get();
        if (activity != null) {
          activity.setPlace(corePlace);
          return activity;
        }
      }
      
      if (defaultProvider != null) {
        CoreActivityProxy<A, P> activity = defaultProvider.get();
        if (activity != null) {
          activity.setPlace(corePlace);
          return activity;
        }
      }
      
      logger.log(Level.SEVERE, "unable to find activity for place " + corePlace.getPlaceKey());
    } else {
      logger.log(Level.SEVERE, "place " + place.getClass().getName() + " is not a CorePlace");
    }
    
    return null;
  }
  
}
