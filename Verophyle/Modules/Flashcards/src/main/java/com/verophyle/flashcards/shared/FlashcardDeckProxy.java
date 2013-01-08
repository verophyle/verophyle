package com.verophyle.flashcards.shared;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.shared.CoreEntityProxy;
import com.verophyle.flashcards.server.FlashcardsLocator;

@ProxyFor(value = FlashcardDeck.class, locator = FlashcardsLocator.class)
public interface FlashcardDeckProxy extends CoreEntityProxy {
	String getName();
	void setName(String name);
	
	int getNum();
	void setNum(int num);
}
