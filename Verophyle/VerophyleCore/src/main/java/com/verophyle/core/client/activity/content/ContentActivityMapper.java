package com.verophyle.core.client.activity.content;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;

public class ContentActivityMapper extends CoreActivityMapper<ContentActivity, CorePlace> {
	
	private Provider<CoreActivityProxy<ContentIndexActivity, Index>> indexActivityProvider;
	private Provider<CoreActivityProxy<ContentSecondActivity, Second>> secondActivityProvider;
	
	@Inject
	public ContentActivityMapper(Provider<CoreActivityProxy<ContentIndexActivity, Index>> indexActivityProvider, 
								 Provider<CoreActivityProxy<ContentSecondActivity, Second>> secondActivityProvider) {
		super(null);
		this.indexActivityProvider = indexActivityProvider;
		this.secondActivityProvider = secondActivityProvider;
	}
	
	@Override
	public Activity getActivity(Place place) {
		CoreActivityProxy<? extends ContentActivity, ? extends CorePlace> activity = null;
		
		if (place instanceof Index) {
			activity = indexActivityProvider.get();
		} else if (place instanceof Second) {
			activity = secondActivityProvider.get();
		}
		
		if (activity != null)
			activity.setPlace((CorePlace)place);
		
		return activity;
	}

}
