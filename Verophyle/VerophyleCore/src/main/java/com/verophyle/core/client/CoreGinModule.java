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
import com.verophyle.core.client.activity.content.ContentActivityManager;
import com.verophyle.core.client.activity.content.ContentActivityMapper;
import com.verophyle.core.client.activity.content.ContentIndexActivity;
import com.verophyle.core.client.activity.content.ContentIndexActivityImpl;
import com.verophyle.core.client.activity.content.ContentSecondActivity;
import com.verophyle.core.client.activity.content.ContentSecondActivityImpl;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.AppView;
import com.verophyle.core.client.view.AppViewImpl;
import com.verophyle.core.client.view.content.ContentIndexView;
import com.verophyle.core.client.view.content.ContentIndexViewImpl;
import com.verophyle.core.client.view.content.ContentSecondView;
import com.verophyle.core.client.view.content.ContentSecondViewImpl;

public class CoreGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// global objects
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(CorePlaceHistoryMapper.class).in(Singleton.class);
		
		// activities
		bind(ContentActivityManager.class).in(Singleton.class);
		bind(ContentActivityMapper.class).in(Singleton.class);
		
		bind(ContentIndexActivity.class).to(ContentIndexActivityImpl.class);
		bind(ContentSecondActivity.class).to(ContentSecondActivityImpl.class);
		
		// views
		bind(AppView.class).to(AppViewImpl.class).in(Singleton.class);

		bind(ContentIndexView.class).to(ContentIndexViewImpl.class).in(Singleton.class);
		bind(ContentSecondView.class).to(ContentSecondViewImpl.class).in(Singleton.class);
	}
	
	// global objects
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
		placeHistoryHandler.register(placeController, eventBus, new Index("1"));
		return placeHistoryHandler;
	}

	// activities
	@Provides
	public CoreActivityProxy<ContentIndexActivity, Index> getMainIndexActivity(AsyncProvider<ContentIndexActivity> provider) {
		return new CoreActivityProxy<ContentIndexActivity, Index>(provider);
	}
	
	@Provides
	public CoreActivityProxy<ContentSecondActivity, Second> getMainSecondActivity(AsyncProvider<ContentSecondActivity> provider) {
		return new CoreActivityProxy<ContentSecondActivity, Second>(provider);
	}
}
