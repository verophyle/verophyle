package com.verophyle.core.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.verophyle.core.client.view.AppView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CoreEntryPoint implements EntryPoint {
	private final CoreGinjector injector = GWT.create(CoreGinjector.class);
	
	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		PlaceHistoryHandler placeHistoryHandler = injector.getPlaceHistoryHandler();
		AppView appView = injector.getAppView();
		
		ActivityManager mainManager = injector.getMainActivityManager();
		mainManager.setDisplay(appView.getContent());

		RootLayoutPanel.get().add(appView);
		
		placeHistoryHandler.handleCurrentHistory();
	}
}