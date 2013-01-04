package com.verophyle.flashcards.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface FlashcardsRequestFactory extends RequestFactory {
	FlashcardDeckRequest flashcardDeckRequest();
}
