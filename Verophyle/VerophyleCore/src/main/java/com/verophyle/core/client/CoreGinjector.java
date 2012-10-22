package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.content.ContentActivityManager;
import com.verophyle.core.client.activity.content.ContentIndexActivity;
import com.verophyle.core.client.activity.content.ContentSecondActivity;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.AppView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	EventBus getEventBus();
	PlaceHistoryHandler getPlaceHistoryHandler();
	
	AppView getAppView();
	
	ContentActivityManager getMainActivityManager();
	CoreActivityProxy<ContentIndexActivity, Index> getMainIndexActivity();
	CoreActivityProxy<ContentSecondActivity, Second> getMainSecondActivity();
}
