package com.verophyle.flashcards.client.activity.content;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.content.ContentActivity;
import com.verophyle.core.client.activity.content.ContentActivityRegistry;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.flashcards.client.FlashcardsLogger;
import com.verophyle.flashcards.client.place.Flashcards;

public class ContentActivityMapper extends CoreActivityMapper<ContentActivity, CorePlace> {

	@Inject
	public ContentActivityMapper(Provider<CoreActivityProxy<ContentFlashcardsActivity, Flashcards>> flashcardsProvider, FlashcardsLogger logger) {
		super(null, logger);
		
		ContentActivityRegistry.get().register(Flashcards.KEY, flashcardsProvider);
	}

}
