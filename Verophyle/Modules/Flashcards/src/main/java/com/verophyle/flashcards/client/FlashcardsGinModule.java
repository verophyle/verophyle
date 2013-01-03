package com.verophyle.flashcards.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.flashcards.client.activity.content.ContentActivityMapper;
import com.verophyle.flashcards.client.activity.content.ContentFlashcardsActivity;
import com.verophyle.flashcards.client.activity.content.ContentFlashcardsActivityImpl;
import com.verophyle.flashcards.client.place.Flashcards;
import com.verophyle.flashcards.client.view.content.ContentFlashcardsView;
import com.verophyle.flashcards.client.view.content.ContentFlashcardsViewImpl;

public class FlashcardsGinModule extends AbstractGinModule {
	
	@Override
	protected void configure() {
		// global objects
		bind(FlashcardsLogger.class).in(Singleton.class);
		
		// activities
		bind(ContentActivityMapper.class).in(Singleton.class);
		
		bind(new TypeLiteral<CoreActivityProxy<ContentFlashcardsActivity, Flashcards>>(){});
		bind(ContentFlashcardsActivity.class).to(ContentFlashcardsActivityImpl.class);
		
		// views
		bind(ContentFlashcardsView.class).to(ContentFlashcardsViewImpl.class).in(Singleton.class);
	}
	
	@Provides
	@Singleton
	public EventBus getEventBus() {
		return CoreGinjector.INSTANCE.getEventBus();
	}

	@Provides
	@Singleton
	public PlaceController getPlaceController(EventBus eventBus) {
		return CoreGinjector.INSTANCE.getPlaceController();
	}
	
}
