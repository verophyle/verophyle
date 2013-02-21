/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.flashcards.shared.rf;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.verophyle.core.server.rf.CoreServiceLocator;
import com.verophyle.flashcards.server.rf.DeckService;

@Service(value = DeckService.class, locator = CoreServiceLocator.class)
public interface DeckRequest extends RequestContext {
  Request<DeckProxy> createDeck(String name);
  Request<DeckProxy> findDeck(Long id);
}
