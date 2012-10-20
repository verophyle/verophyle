package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.MainActivityManager;
import com.verophyle.core.client.view.MainView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	EventBus getEventBus();
	PlaceHistoryHandler getPlaceHistoryHandler();
	
	MainActivityManager getMainActivityManager();
	MainView getMainView();
}
