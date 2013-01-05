package com.verophyle.flashcards.server;

import java.util.HashMap;

import com.verophyle.flashcards.domain.FlashcardDeck;

public class FlashcardDeckService {
	
	static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();

	public FlashcardDeck createDeck(String name) {
		FlashcardDeck deck = new FlashcardDeck();
		deck.setName(name);
		decks.put(deck.getId(), deck);
		return deck;
	}
	
	public FlashcardDeck findDeck(Long id) {
		return decks.get(id);
	}
	
}
