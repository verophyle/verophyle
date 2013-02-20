/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.activity;

import java.util.logging.Level;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;

/**
 * Base class for Verophyle activities.
 * @param <P> The Place class.
 * @param <V> The View class.
 */
public abstract class CoreActivityImpl<P extends CorePlace, V extends CoreView> implements CoreActivity {
	
	private CoreLogger logger;
	private PlaceController placeController;
	private CorePlace place;
	private CoreView view;

	/**
	 * Must be called by subclasses, using the parameters supplied by injection.
	 * 
	 * @param logger Logger.
	 * @param placeController Place controller.
	 * @param coreView View.
	 */
	protected CoreActivityImpl(CoreLogger logger, PlaceController placeController, CoreView coreView) {
		this.logger = logger;
		this.placeController = placeController;
		this.view = coreView;
	}
	
	/**
	 * Log a message.
	 * @param level Log level.
	 * @param text Log message.
	 */
	protected void log(Level level, String text) {
		logger.log(level, text);
	}

	/**
	 * Gets this activity's view.
	 */
	@Override
	public CoreView getView() {
		return view;
	}
	
	/**
	 * Get this activity's place.
	 */
	@Override
	public CorePlace getPlace() {
		return place;
	}
		
	/**
	 * Set the activity's place.
	 */
	@Override
	public void setPlace(CorePlace place) {
		this.place = place;
	}

	/**
	 * Go to a different place.
	 */
	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

	/**
	 * Message to show to the user when choosing to go to a new place or not.
	 * Returns null in the base class.
	 */
	@Override
	public String mayStop() {
		return null;
	}

	/**
	 * Called when the activity is cancelled.  Should be called from subclasses' implementations.
	 */
	@Override
	public void onCancel() {
		log(Level.INFO, this.getClass().getName() + " onCancel()");
	}

	/**
	 * Called when the activity is stopped.  Should be called from subclasses' implementations.
	 */
	@Override
	public void onStop() {
		log(Level.INFO, this.getClass().getName() + " onStop()");
	}

	/**
	 * Called when the activity is started.  Must be called from subclasses' implementations.
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		log(Level.INFO, this.getClass().getName() + " start()");
		
		view.setPresenter(this);
		panel.setWidget(view.asWidget());
	}

}
