package com.verophyle.core.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.activity.content.ContentActivity;
import com.verophyle.core.client.activity.content.ContentActivityManager;
import com.verophyle.core.client.activity.footer.FooterActivityManager;
import com.verophyle.core.client.activity.header.HeaderActivityManager;
import com.verophyle.core.client.activity.sidebar.SidebarActivityManager;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.place.CorePlaceHistoryRegistry;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.AppView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	CoreGinjector INSTANCE = GWT.create(CoreGinjector.class);
	
	CoreLogger getLogger();
	CoreResources getCoreResources();
	
	EventBus getEventBus();
	PlaceController getPlaceController();	

	PlaceHistoryMapper getPlaceHistoryMapper();
	PlaceHistoryHandler getPlaceHistoryHandler();
	CorePlaceHistoryRegistry getPlaceHistoryRegistry();
	
	AppView getAppView();	
	
	HeaderActivityManager getHeaderActivityManager();
	SidebarActivityManager getSidebarActivityManager();
	FooterActivityManager getFooterActivityManager();

	CoreActivityRegistry<ContentActivity, CorePlace> getContentActivityRegistry();
	ContentActivityManager getContentActivityManager();
}
