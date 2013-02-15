package com.verophyle.core.client.activity;

import java.util.logging.Level;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;

public abstract class CoreActivityImpl<P extends CorePlace, V extends CoreView> implements CoreActivity {
	
	private CoreLogger logger;
	private PlaceController placeController;
	private CorePlace place;
	private CoreView view;

	protected CoreActivityImpl(CoreLogger logger, PlaceController placeController, CoreView coreView) {
		this.logger = logger;
		this.placeController = placeController;
		this.view = coreView;
	}
	
	protected void log(Level level, String text) {
		logger.log(level, text);
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
		log(Level.INFO, this.getClass().getName() + " onCancel()");
	}

	@Override
	public void onStop() {
		log(Level.INFO, this.getClass().getName() + " onStop()");
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		log(Level.INFO, this.getClass().getName() + " start()");
		
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

}
