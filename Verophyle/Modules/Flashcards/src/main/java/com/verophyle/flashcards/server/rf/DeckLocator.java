package com.verophyle.flashcards.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class DeckLocator extends CoreLocator<FlashcardDeck, Long> {
	
	@Inject
	public DeckLocator(Injector injector) {
		super(injector);
	}
	
	@Override
	public FlashcardDeck create(Class<? extends FlashcardDeck> clazz) {
		return super.create(clazz);
	}
	
	@Override
	public FlashcardDeck find(Class<? extends FlashcardDeck> clazz, Long id) {
		return null;
	}
	
	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Class<FlashcardDeck> getDomainType() {
		return FlashcardDeck.class;
	}
	
}
