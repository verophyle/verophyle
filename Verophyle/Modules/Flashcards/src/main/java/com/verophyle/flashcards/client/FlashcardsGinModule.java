package com.verophyle.flashcards.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.verophyle.core.client.CoreLogger;

public class FlashcardsGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		// global objects
		bind(CoreLogger.class).to(FlashcardsLoggerImpl.class).in(Singleton.class);
	}

}
