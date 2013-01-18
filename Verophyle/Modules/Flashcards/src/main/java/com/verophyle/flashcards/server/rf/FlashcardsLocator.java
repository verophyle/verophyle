package com.verophyle.flashcards.server.rf;

import java.util.HashMap;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class FlashcardsLocator extends CoreLocator<FlashcardDeck, Long> {
	
	private static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();
	
	@Inject
	public FlashcardsLocator(Injector injector) {
		super(injector);
	}
	
	@Override
	public FlashcardDeck create(Class<? extends FlashcardDeck> clazz) {
		FlashcardDeck deck = super.create(clazz);
		decks.put(deck.getId(), deck);			
		return deck;
	}
	
	@Override
	public FlashcardDeck find(Class<? extends FlashcardDeck> clazz, Long id) {
		return decks.get(id);
	}
	
	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}
	
}
