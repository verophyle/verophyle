package com.verophyle.core.client.activity.content;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;

public class ContentActivityMapper implements ActivityMapper {
	
	CoreGinjector injector;
	
	@Inject
	public ContentActivityMapper(CoreGinjector injector) {
		this.injector = injector;
	}
	
	@Override
	public Activity getActivity(Place place) {
		
		if (place instanceof Index) {
			CoreActivityProxy<ContentIndexActivity, Index> activity = injector.getActivity();
			activity.setPlace((Index) place);
			return activity;
		}
		
		if (place instanceof Second) {
			CoreActivityProxy<ContentSecondActivity, Second> activity = injector.getMainSecondActivity();
			activity.setPlace((Second) place);
			return activity;
		}
		
		return null;
	}

}
