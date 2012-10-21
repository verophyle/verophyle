package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.place.Main;

public class MainActivityMapper implements ActivityMapper {
	
	CoreGinjector injector;
	
	@Inject
	public MainActivityMapper(CoreGinjector injector) {
		super();
		this.injector = injector;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof Main) {
			CoreActivityProxy<MainActivity, Main> activity = injector.getMainActivity();
			activity.setPlace((Main) place);
			return activity;
		}
		return null;
	}

}
