package com.verophyle.core.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.main.MainActivityManager;
import com.verophyle.core.client.activity.main.MainActivityMapper;
import com.verophyle.core.client.activity.main.MainIndexActivity;
import com.verophyle.core.client.activity.main.MainSecondActivity;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.AppView;
import com.verophyle.core.client.view.AppViewImpl;
import com.verophyle.core.client.view.main.MainIndexView;
import com.verophyle.core.client.view.main.MainSecondView;

public class CoreGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(CorePlaceHistoryMapper.class).in(Singleton.class);
		
		bind(AppView.class).to(AppViewImpl.class).in(Singleton.class);

		bind(MainActivityManager.class).in(Singleton.class);
		bind(MainActivityMapper.class).in(Singleton.class);
		
		bind(MainIndexView.class).in(Singleton.class);
		bind(MainSecondView.class).in(Singleton.class);
	}
	
	@Provides
	@Singleton
	public PlaceController getPlaceController(EventBus eventBus) {
		return new PlaceController(eventBus);
	}
	
	@Provides
	@Singleton
	public PlaceHistoryHandler getHistoryHandler(PlaceController placeController, 
												PlaceHistoryMapper placeHistoryMapper,
												EventBus eventBus) {
		PlaceHistoryHandler placeHistoryHandler = new PlaceHistoryHandler(placeHistoryMapper);
		placeHistoryHandler.register(placeController, eventBus, new Index("First light!"));
		return placeHistoryHandler;
	}

	@Provides
	public CoreActivityProxy<MainIndexActivity, Index> getMainIndexActivity(AsyncProvider<MainIndexActivity> provider) {
		return new CoreActivityProxy<MainIndexActivity, Index>(provider);
	}
	
	@Provides
	public CoreActivityProxy<MainSecondActivity, Second> getMainSecondActivity(AsyncProvider<MainSecondActivity> provider) {
		return new CoreActivityProxy<MainSecondActivity, Second>(provider);
	}
}
