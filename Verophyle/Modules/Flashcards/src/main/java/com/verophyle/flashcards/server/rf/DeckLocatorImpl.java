package com.verophyle.flashcards.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocatorImpl;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class DeckLocatorImpl extends CoreLocatorImpl<FlashcardDeck, Long> implements DeckLocator {
	
	@Inject
	public DeckLocatorImpl(Injector injector) {
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
