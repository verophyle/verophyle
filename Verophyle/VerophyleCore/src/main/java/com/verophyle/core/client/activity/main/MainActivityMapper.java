package com.verophyle.core.client.activity.main;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;

public class MainActivityMapper implements ActivityMapper {
	
	CoreGinjector injector;
	
	@Inject
	public MainActivityMapper(CoreGinjector injector) {
		super();
		this.injector = injector;
	}
	
	@Override
	public Activity getActivity(Place place) {
		
		if (place instanceof Index) {
			CoreActivityProxy<MainIndexActivity, Index> activity = injector.getMainIndexActivity();
			activity.setPlace((Index) place);
			return activity;
		}
		
		if (place instanceof Second) {
			CoreActivityProxy<MainSecondActivity, Second> activity = injector.getMainSecondActivity();
			activity.setPlace((Second) place);
			return activity;
		}
		
		return null;
	}

}
