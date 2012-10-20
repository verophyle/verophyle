package com.verophyle.core.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.verophyle.core.client.activity.MainActivity;
import com.verophyle.core.client.activity.MainActivityManager;
import com.verophyle.core.client.activity.MainActivityMapper;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.core.client.place.MainPlace;
import com.verophyle.core.client.view.DefaultMainView;
import com.verophyle.core.client.view.MainView;

public class CoreGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(CorePlaceHistoryMapper.class).in(Singleton.class);

		bind(MainActivityManager.class).in(Singleton.class);
		bind(MainActivityMapper.class).in(Singleton.class);
		bind(MainActivity.class);
		bind(MainView.class).to(DefaultMainView.class).in(Singleton.class);
	}
	
	@Provides
	@Singleton
	public PlaceController getPlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}
	
	@Provides
	@Singleton
	public PlaceHistoryHandler getHistoryHandler(
			PlaceController placeController, 
			PlaceHistoryMapper placeHistoryMapper,
			EventBus eventBus) {
		PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(placeHistoryMapper);
		placeHistoryHandler.register(placeController, eventBus, new MainPlace("The default place."));
		return placeHistoryHandler;
	}
	
}
