package com.verophyle.core.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.Composite;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;

public class CoreView extends Composite {
	private static PlaceHistoryMapper placeHistoryMapper = GWT.create(CorePlaceHistoryMapper.class);

	protected static String getHistoryToken(Place place) {
		return placeHistoryMapper.getToken(place);
	}
	
}
