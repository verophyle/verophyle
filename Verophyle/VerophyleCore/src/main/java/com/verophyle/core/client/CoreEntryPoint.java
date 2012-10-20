package com.verophyle.core.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CoreEntryPoint implements EntryPoint {
	private final CoreGinjector injector = GWT.create(CoreGinjector.class);
	private final SimplePanel appPanel = new SimplePanel();
	
	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		PlaceHistoryHandler placeHistoryHandler = injector.getPlaceHistoryHandler();
		ActivityManager mainManager = injector.getMainActivityManager();
		mainManager.setDisplay(appPanel);		

		RootPanel.get().add(appPanel);
		
		placeHistoryHandler.handleCurrentHistory();
	}
}
