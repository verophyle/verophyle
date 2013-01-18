package com.verophyle.flashcards.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.rf.CoreServiceLocator;

public class FlashcardsServiceLocator extends CoreServiceLocator {

	@Inject
	protected FlashcardsServiceLocator(Injector injector) {
		super(injector);
	}

}
