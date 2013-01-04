package com.verophyle.flashcards.server;

import com.verophyle.flashcards.domain.FlashcardDeck;

public class FlashcardDeckService {

	public FlashcardDeck createDeck(String name) {
		FlashcardDeck deck = new FlashcardDeck();
		deck.setName(name);
		return deck;
	}
	
}
