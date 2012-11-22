package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.place.CorePlace;

public abstract class CoreActivityMapper<A extends CoreActivity, P extends CorePlace> implements ActivityMapper {

	protected CoreGinjector injector;
	
	public CoreActivityMapper(CoreGinjector injector) {
		this.injector = injector;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof CorePlace) {
			CoreActivityProxy<A, P> activity = injector.getActivity();
			activity.setPlace((CorePlace)place);
			return activity;
		}
		
		return null;
	}
	
}
