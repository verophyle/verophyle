package com.verophyle.flashcards.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class DeckLocator extends CoreLocator<FlashcardDeck, Long> {
	@Inject
	public DeckLocator(Injector injector) {
		super(injector, FlashcardDeck.class, Long.class);
	}
}
