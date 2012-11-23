package com.verophyle.core.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;

public abstract class CoreActivityImpl<P extends CorePlace, V extends CoreView> implements CoreActivity {
	
	private PlaceController placeController;
	private CorePlace place;
	private CoreView view;

	protected CoreActivityImpl(PlaceController placeController, CoreView coreView) {
		this.placeController = placeController;
		this.view = coreView;
	}

	@Override
	public CoreView getView() {
		return view;
	}
	
	@Override
	public CorePlace getPlace() {
		return place;
	}
		
	@Override
	public void setPlace(CorePlace place) {
		this.place = place;
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
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
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

}
