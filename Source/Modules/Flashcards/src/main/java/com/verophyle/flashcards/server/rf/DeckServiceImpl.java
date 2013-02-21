/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.flashcards.server.rf;

import java.util.HashMap;

import org.slf4j.Logger;

import com.google.inject.Inject;
import com.verophyle.core.server.rf.CoreLocator;
import com.verophyle.flashcards.server.domain.FlashcardDeck;

public class DeckServiceImpl implements DeckService {
  
  static HashMap<Long, FlashcardDeck> decks = new HashMap<Long, FlashcardDeck>();

  private final Logger logger;
  private final CoreLocator<FlashcardDeck> locator;  
  
  @Inject
  public DeckServiceImpl(Logger logger, DeckLocator locator) {
    this.logger = logger;
    this.locator = locator;
  }
  
  public FlashcardDeck createDeck(String name) {
    logger.info("createDeck(" + name + ")");    
    
    FlashcardDeck deck = locator.create(FlashcardDeck.class);
    deck.setName(name);
    decks.put(deck.getId(), deck);
    return deck;
  }
  
  public FlashcardDeck findDeck(Long id) {    
    return decks.get(id);
  }
  
}
