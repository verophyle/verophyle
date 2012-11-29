package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.content.ContentActivityManager;
import com.verophyle.core.client.activity.content.ContentIndexActivity;
import com.verophyle.core.client.activity.content.ContentSecondActivity;
import com.verophyle.core.client.activity.footer.FooterActivity;
import com.verophyle.core.client.activity.footer.FooterActivityManager;
import com.verophyle.core.client.activity.header.HeaderActivity;
import com.verophyle.core.client.activity.header.HeaderActivityManager;
import com.verophyle.core.client.activity.sidebar.SidebarActivity;
import com.verophyle.core.client.activity.sidebar.SidebarActivityManager;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.AppView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	CoreLogger getLogger();
	
	CoreResources getCoreResources();
	
	EventBus getEventBus();
	PlaceHistoryHandler getPlaceHistoryHandler();
	
	AppView getAppView();
	
	HeaderActivityManager getHeaderActivityManager();
	CoreActivityProxy<HeaderActivity, CorePlace> getHeaderActivity();

	SidebarActivityManager getSidebarActivityManager();
	CoreActivityProxy<SidebarActivity, CorePlace> getSidebarActivity();
	
	FooterActivityManager getFooterActivityManager();
	CoreActivityProxy<FooterActivity, CorePlace> getFooterActivity();
	
	ContentActivityManager getContentActivityManager();
	CoreActivityProxy<ContentIndexActivity, Index> getContentIndexActivity();
	CoreActivityProxy<ContentSecondActivity, Second> getContentSecondActivity();
}
