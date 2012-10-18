package com.verophyle.core.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.activity.MainActivityMapper;
import com.verophyle.core.client.place.MainPlace;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VerophyleCore implements EntryPoint {
	private Place defaultPlace = new MainPlace("This is the default place.");
	private SimplePanel appWidget = new SimplePanel();
	
	/**
	 * Entry point method.
	 */
	public void onModuleLoad() {
		// TODO: replace this with GIN
		TempFactory tempFactory = GWT.create(TempFactory.class);
		EventBus eventBus = tempFactory.getEventBus();
		PlaceController placeController = tempFactory.getPlaceController();
		
		// start activity manager
		ActivityMapper mainMapper = new MainActivityMapper(tempFactory);
		ActivityManager mainManager = new ActivityManager(mainMapper, eventBus);
		mainManager.setDisplay(appWidget);
		
		// start place history handler
		CorePlaceHistoryMapper historyMapper = GWT.create(CorePlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		// set root widget
		RootPanel.get().add(appWidget);
		
		// go to the place specified in the URL
		historyHandler.handleCurrentHistory();
	}
}
