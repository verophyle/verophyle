package com.verophyle.core.client;

import java.util.logging.Level;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.AppView;

public class CoreEntryPoint implements EntryPoint {
	private final CoreGinjector injector = GWT.create(CoreGinjector.class);
	
	public void onModuleLoad() {
		injector.getLogger().log(Level.INFO, this.getClass().getName() + " onModuleLoad()");
		
		CorePlaceHistoryMapper.register(Index.KEY, new Index.Tokenizer());
		
		AppView appView = injector.getAppView();
		
		ActivityManager headerManager = injector.getHeaderActivityManager();
		headerManager.setDisplay(appView.getHeader());
		
		ActivityManager sidebarManager = injector.getSidebarActivityManager();
		sidebarManager.setDisplay(appView.getSidebar());
		
		ActivityManager footerManager = injector.getFooterActivityManager();
		footerManager.setDisplay(appView.getFooter());
		
		ActivityManager contentManager = injector.getContentActivityManager();
		contentManager.setDisplay(appView.getContent());

		RootLayoutPanel.get().add(appView);
		
		PlaceHistoryHandler placeHistoryHandler = injector.getPlaceHistoryHandler();
		placeHistoryHandler.handleCurrentHistory();
	}	
}
