/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
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

/**
 * Entry point for the Core module.
 * 
 * Initialization is delayed until all modules are loaded, then {@link #init()} is called, then {@link #start()} is called.
 */
public class CoreEntryPoint implements EntryPoint {
  private static boolean loaded = false;
  
  /**
   * Called when the module is loaded.
   */
  public void onModuleLoad() {
    CoreGinjector.INSTANCE.getLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
    loaded = true;
  }
  
  /**
   * Whether or not the module has been loaded.
   */
  public static boolean isLoaded() {
    return loaded;
  }

  /**
   * Initialized the module.
   */
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
  
  /**
   * Performs startup actions on the module.
   */
  public static void start() {    
    CoreGinjector.INSTANCE.getLogger().log(Level.INFO, "CoreEntryPoint.start()");

    PlaceHistoryHandler placeHistoryHandler = CoreGinjector.INSTANCE.getPlaceHistoryHandler();
    placeHistoryHandler.handleCurrentHistory();    
  }
  
}
