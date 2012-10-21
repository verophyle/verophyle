package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.MainActivity;
import com.verophyle.core.client.activity.MainActivityManager;
import com.verophyle.core.client.place.Main;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	EventBus getEventBus();
	PlaceHistoryHandler getPlaceHistoryHandler();
	
	MainActivityManager getMainActivityManager();
	CoreActivityProxy<MainActivity, Main> getMainActivity();
}
