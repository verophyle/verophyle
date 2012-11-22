package com.verophyle.core.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.verophyle.core.client.CoreResources;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;

public abstract class CoreViewImpl extends Composite implements CoreView {
	
	private static PlaceHistoryMapper placeHistoryMapper = GWT.create(CorePlaceHistoryMapper.class);

	protected CorePresenter presenter;
	
	protected CoreViewImpl(CoreResources res) {
		res.css().ensureInjected();
	}

	public Widget asWidget() {
		return this;
	}

	public void setPresenter(CorePresenter presenter) {
		this.presenter = presenter;
	}
	
	protected static String getHistoryToken(Place place) {
		return placeHistoryMapper.getToken(place);
	}
	
}
