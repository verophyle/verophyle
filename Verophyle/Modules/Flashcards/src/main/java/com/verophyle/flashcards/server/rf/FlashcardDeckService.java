package com.verophyle.flashcards.server.rf;

import java.util.HashMap;

import org.slf4j.Logger;

import com.google.inject.Inject;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public class FlashcardDeckService {
	
	static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();

	private Logger logger;
	
	@Inject
	public FlashcardDeckService(Logger logger) {
		this.logger = logger;
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
