package com.verophyle.core.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Composite;

public class CoreView extends Composite {

	protected static String getHistoryToken(Class<? extends Place> placeClass, String token) {
		return placeClass.getSimpleName() + ":" + token;
	}
	
}
