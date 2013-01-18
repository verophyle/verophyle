package com.verophyle.flashcards.shared.rf;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.verophyle.flashcards.server.rf.FlashcardDeckService;
import com.verophyle.flashcards.server.rf.FlashcardsServiceLocator;

@Service(value = FlashcardDeckService.class, locator = FlashcardsServiceLocator.class)
public interface FlashcardDeckRequest extends RequestContext {
	Request<FlashcardDeckProxy> createDeck(String name);
	Request<FlashcardDeckProxy> findDeck(Long id);
}
