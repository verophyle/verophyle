package com.verophyle.flashcards.server.rf;

import com.verophyle.flashcards.shared.domain.FlashcardDeck;

public interface DeckService {
	FlashcardDeck createDeck(String name);
	FlashcardDeck findDeck(Long id);
}

