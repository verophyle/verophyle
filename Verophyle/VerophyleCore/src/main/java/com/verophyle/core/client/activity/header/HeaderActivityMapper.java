package com.verophyle.core.client.activity.header;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.CorePlace;

public class HeaderActivityMapper implements ActivityMapper {
	
	CoreGinjector injector;
	
	@Inject
	public HeaderActivityMapper(CoreGinjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof CorePlace) {	
			CoreActivityProxy<HeaderActivity, CorePlace> activity = injector.getHeaderActivity();		
			activity.setPlace((CorePlace)place);
			return activity;
		}
		
		return null;
	}

}
