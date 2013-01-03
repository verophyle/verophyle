package com.verophyle.flashcards.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.flashcards.client.activity.content.ContentActivityMapper;
import com.verophyle.flashcards.client.activity.content.ContentFlashcardsActivity;
import com.verophyle.flashcards.client.place.Flashcards;

@GinModules({FlashcardsGinModule.class})
public interface FlashcardsGinjector extends Ginjector {
	FlashcardsGinjector INSTANCE = GWT.create(FlashcardsGinjector.class);
	
	FlashcardsLogger getLogger();
	
	ContentActivityMapper getContentActivityMapper();
	CoreActivityProxy<ContentFlashcardsActivity, Flashcards> getContentFlashcardsActivity();
}
