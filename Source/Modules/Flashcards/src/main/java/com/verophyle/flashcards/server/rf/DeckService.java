/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.server.rf;

import com.verophyle.flashcards.server.domain.FlashcardDeck;

public interface DeckService {
  FlashcardDeck createDeck(String name);
  FlashcardDeck findDeck(Long id);
}

