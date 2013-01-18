package com.verophyle.flashcards.server;

import com.google.inject.AbstractModule;
import com.verophyle.flashcards.server.rf.FlashcardDeckService;
import com.verophyle.flashcards.server.rf.FlashcardsServiceLocator;

public class FlashcardsGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FlashcardDeckService.class);
		bind(FlashcardsServiceLocator.class);
	}

}
