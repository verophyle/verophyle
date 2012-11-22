package com.verophyle.core.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;

public abstract class CoreActivityImpl<P extends CorePlace, V extends CoreView> implements CoreActivity {
	
	private PlaceController placeController;
	private CorePlace corePlace;
	private CoreView coreView;

	protected CoreActivityImpl(PlaceController placeController, CoreView coreView) {
		this.placeController = placeController;
		this.coreView = coreView;
	}
	
	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {
	}

	@Override
	public void onStop() {
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		coreView.setPresenter(this);
		panel.setWidget(coreView.asWidget());
	}

	@Override
	public void setPlace(CorePlace place) {
		this.corePlace = place;
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
