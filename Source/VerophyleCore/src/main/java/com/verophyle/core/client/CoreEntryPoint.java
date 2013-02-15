package com.verophyle.core.client;

import java.util.logging.Level;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.AppView;

public class CoreEntryPoint implements EntryPoint {
	private static boolean loaded = false;
	
	public void onModuleLoad() {
		CoreGinjector.INSTANCE.getLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
		loaded = true;
	}
	
	public static boolean isLoaded() {
		return loaded;
	}
	
	public static void init() {
		GWT.setUncaughtExceptionHandler(new CoreUncaughtExceptionHandler());
		
		CoreGinjector injector = CoreGinjector.INSTANCE;
		
		injector.getLogger().log(Level.INFO, "CoreEntryPoint.init()");

		injector.getPlaceHistoryRegistry().register(Index.KEY, new Index.Tokenizer());
		injector.getPlaceHistoryRegistry().register(Second.KEY, new Second.Tokenizer());
		
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
	}
	
	public static void start() {		
		CoreGinjector.INSTANCE.getLogger().log(Level.INFO, "CoreEntryPoint.start()");

		PlaceHistoryHandler placeHistoryHandler = CoreGinjector.INSTANCE.getPlaceHistoryHandler();
		placeHistoryHandler.handleCurrentHistory();		
	}
	
}