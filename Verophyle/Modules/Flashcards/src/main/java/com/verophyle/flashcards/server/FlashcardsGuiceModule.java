package com.verophyle.flashcards.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class FlashcardsGuiceModule extends AbstractModule {
	public static final Injector INJECTOR = Guice.createInjector(new FlashcardsGuiceModule());

	@Override
	protected void configure() {
	}

	@Provides
	@Singleton
	public Logger getLogger() {
		return LoggerFactory.getLogger(FlashcardDeckService.class);
	}
	
}
