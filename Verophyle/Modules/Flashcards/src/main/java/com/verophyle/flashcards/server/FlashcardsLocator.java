package com.verophyle.flashcards.server;

import java.util.HashMap;

import com.verophyle.core.server.CoreLocator;
import com.verophyle.flashcards.shared.FlashcardDeck;

public class FlashcardsLocator extends CoreLocator<FlashcardDeck, Long> {
	
	private static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();
	
	@Override
	public FlashcardDeck create(Class<? extends FlashcardDeck> clazz) {
		try {
			FlashcardDeck deck = clazz.newInstance();
			decks.put(deck.getId(), deck);			
			return deck;
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
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
