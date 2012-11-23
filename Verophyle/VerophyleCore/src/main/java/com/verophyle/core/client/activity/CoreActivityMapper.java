package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;
import com.verophyle.core.client.place.CorePlace;

public abstract class CoreActivityMapper<A extends CoreActivity, P extends CorePlace> implements ActivityMapper {	

	Provider<CoreActivityProxy<A, P>> defaultProvider;
	
	public CoreActivityMapper(Provider<CoreActivityProxy<A, P>> defaultProvider) {
		this.defaultProvider = defaultProvider;
	}
		
	@Override
	public Activity getActivity(Place place) {
		CoreActivityProxy<A, P> activity = null; 
		
		if (place instanceof CorePlace && defaultProvider != null) {
			activity = defaultProvider.get();
		}

		if (activity != null)
			activity.setPlace((CorePlace)place);
		
		return activity;
	}
	
}
