package com.verophyle.core.client.activity;

import java.util.logging.Level;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;

public abstract class CoreActivityMapper<A extends CoreActivity, P extends CorePlace> implements ActivityMapper {	
	private CoreActivityRegistry registry;
	private Provider<CoreActivityProxy<A, P>> defaultProvider;
	private CoreLogger logger;
	
	public CoreActivityMapper(CoreActivityRegistry registry, Provider<CoreActivityProxy<A, P>> defaultProvider, CoreLogger logger) {
		this.registry = registry;
		this.defaultProvider = defaultProvider;
		this.logger = logger;
	}
	
	protected void register(String placeKey, Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> provider) {
		registry.register(placeKey, provider);
	}
	
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
