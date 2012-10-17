package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.verophyle.core.client.TempFactory;
import com.verophyle.core.client.place.MainPlace;

public class MainActivityMapper implements ActivityMapper {
	private TempFactory tempFactory;
	
	public MainActivityMapper(TempFactory tempFactory) {
		super();
		this.tempFactory = tempFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MainPlace)
			return new MainActivity((MainPlace) place, tempFactory);
		
		return null;
	}

}
