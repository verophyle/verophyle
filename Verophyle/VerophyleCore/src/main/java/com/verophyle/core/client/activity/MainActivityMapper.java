package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.verophyle.core.client.place.MainPlace;

public class MainActivityMapper implements ActivityMapper {
	
	private final AsyncProvider<MainActivity> mainActivityProvider;
	
	@Inject
	public MainActivityMapper(AsyncProvider<MainActivity> mainActivityProvider) {
		super();
		this.mainActivityProvider = mainActivityProvider;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MainPlace)
		{
			ActivityCallback<MainActivity> callback = new ActivityCallback<MainActivity>() { };
						
			mainActivityProvider.get(callback);
			
			try {
				callback.wait();
				
				if (callback.hasResult())
					return callback.getResult();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		} 
		
		return null;
	}

}
