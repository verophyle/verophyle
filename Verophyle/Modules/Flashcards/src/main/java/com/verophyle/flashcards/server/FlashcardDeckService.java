package com.verophyle.flashcards.server;

import java.util.HashMap;

import org.slf4j.Logger;

import com.verophyle.flashcards.shared.FlashcardDeck;

public class FlashcardDeckService {
	
	static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();

	private Logger logger;
	
	public FlashcardDeckService() {
		this.logger = FlashcardsGuiceModule.INJECTOR.getInstance(Logger.class);
	}
	
	public FlashcardDeck createDeck(String name) {
		logger.info("createDeck(" + name + ")");
		
		FlashcardDeck deck = new FlashcardDeck();
		deck.setName(name);
		decks.put(deck.getId(), deck);
		return deck;
	}
	
	public FlashcardDeck findDeck(Long id) {		
		return decks.get(id);
	}
	
}
