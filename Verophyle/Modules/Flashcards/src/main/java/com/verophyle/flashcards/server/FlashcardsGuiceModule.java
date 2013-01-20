package com.verophyle.flashcards.server;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.verophyle.flashcards.server.rf.DeckLocator;
import com.verophyle.flashcards.server.rf.DeckLocatorImpl;
import com.verophyle.flashcards.server.rf.DeckService;
import com.verophyle.flashcards.server.rf.DeckServiceImpl;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class FlashcardsGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(FlashcardDeck.class);
		bind(DeckLocator.class).to(DeckLocatorImpl.class).in(Singleton.class);		
		bind(DeckService.class).to(DeckServiceImpl.class).in(Singleton.class);
	}

}
