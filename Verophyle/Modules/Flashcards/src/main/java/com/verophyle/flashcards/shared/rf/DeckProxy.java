package com.verophyle.flashcards.shared.rf;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.shared.rf.CoreEntityProxy;
import com.verophyle.flashcards.server.rf.DeckLocator;
import com.verophyle.flashcards.shared.domain.FlashcardDeck;

@ProxyFor(value = FlashcardDeck.class, locator = DeckLocator.class)
public interface DeckProxy extends CoreEntityProxy {
	String getName();
	void setName(String name);
	
	int getNum();
	void setNum(int num);
}
