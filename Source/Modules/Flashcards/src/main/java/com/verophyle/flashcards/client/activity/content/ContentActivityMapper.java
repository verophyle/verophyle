/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.flashcards.client.activity.content;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.activity.content.ContentActivity;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.flashcards.client.FlashcardsLogger;
import com.verophyle.flashcards.client.place.Flashcards;

public class ContentActivityMapper extends CoreActivityMapper<ContentActivity, CorePlace> {

	@Inject
	public ContentActivityMapper(CoreActivityRegistry<ContentActivity, CorePlace> registry, 
								 Provider<CoreActivityProxy<ContentFlashcardsActivity, Flashcards>> flashcardsProvider, 
								 FlashcardsLogger logger) {
		super(registry, null, logger);
		
		register(Flashcards.KEY, flashcardsProvider);
	}

}
