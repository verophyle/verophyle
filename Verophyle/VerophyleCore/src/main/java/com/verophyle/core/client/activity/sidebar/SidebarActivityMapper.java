package com.verophyle.core.client.activity.sidebar;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.CorePlace;

public class SidebarActivityMapper implements ActivityMapper {

	private CoreGinjector injector;
	
	@Inject
	public SidebarActivityMapper(CoreGinjector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof CorePlace) {
			CoreActivityProxy<SidebarActivity, CorePlace> activity = injector.getActivity();
			activity.setPlace((CorePlace)place);
			return activity;
		}
		
		return null;
	}
	
}
