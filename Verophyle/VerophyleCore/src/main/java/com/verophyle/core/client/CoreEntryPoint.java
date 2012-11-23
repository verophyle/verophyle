package com.verophyle.core.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.verophyle.core.client.view.AppView;

public class CoreEntryPoint implements EntryPoint {
	private final CoreGinjector injector = GWT.create(CoreGinjector.class);
	
	public void onModuleLoad() {
		AppView appView = injector.getAppView();
		
		ActivityManager headerManager = injector.getHeaderActivityManager();
		headerManager.setDisplay(appView.getHeader());
		
		ActivityManager sidebarManager = injector.getSidebarActivityManager();
		sidebarManager.setDisplay(appView.getSidebar());
		
		ActivityManager contentManager = injector.getContentActivityManager();
		contentManager.setDisplay(appView.getContent());

		RootLayoutPanel.get().add(appView);
		
		PlaceHistoryHandler placeHistoryHandler = injector.getPlaceHistoryHandler();
		placeHistoryHandler.handleCurrentHistory();
	}	
}
