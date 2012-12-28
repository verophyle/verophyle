package com.verophyle.flashcards.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.verophyle.core.client.CoreLogger;

@GinModules({FlashcardsGinModule.class})
public interface FlashcardsGinjector extends Ginjector {
	CoreLogger getLogger();
}
