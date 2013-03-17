/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.shared.rf;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface FlashcardsRequestFactory extends RequestFactory {
  DeckRequest flashcardDeckRequest();
}
