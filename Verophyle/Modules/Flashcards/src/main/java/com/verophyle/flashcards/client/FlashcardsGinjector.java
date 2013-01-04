package com.verophyle.flashcards.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.verophyle.core.client.place.CorePlaceHistoryRegistry;
import com.verophyle.flashcards.client.activity.content.ContentActivityMapper;
import com.verophyle.flashcards.shared.FlashcardsRequestFactory;

@GinModules({FlashcardsGinModule.class})
public interface FlashcardsGinjector extends Ginjector {
	FlashcardsGinjector INSTANCE = GWT.create(FlashcardsGinjector.class);
	
	FlashcardsLogger getLogger();
	CorePlaceHistoryRegistry getPlaceHistoryRegistry();
	
	FlashcardsRequestFactory getRequestFactory(); 
	
	ContentActivityMapper registerContentActivityMapper();
}
