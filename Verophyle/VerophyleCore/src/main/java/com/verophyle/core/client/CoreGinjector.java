package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.main.MainIndexActivity;
import com.verophyle.core.client.activity.main.MainActivityManager;
import com.verophyle.core.client.activity.main.MainSecondActivity;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.AppView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	EventBus getEventBus();
	PlaceHistoryHandler getPlaceHistoryHandler();
	
	AppView getAppView();
	
	MainActivityManager getMainActivityManager();
	CoreActivityProxy<MainIndexActivity, Index> getMainIndexActivity();
	CoreActivityProxy<MainSecondActivity, Second> getMainSecondActivity();
}
