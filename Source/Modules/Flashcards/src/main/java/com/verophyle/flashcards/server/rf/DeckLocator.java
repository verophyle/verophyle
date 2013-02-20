/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.flashcards.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.flashcards.server.domain.FlashcardDeck;

public class DeckLocator extends CoreLocator<FlashcardDeck> {
	@Inject
	public DeckLocator(Injector injector) {
		super(injector, FlashcardDeck.class);
	}
}
