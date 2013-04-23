/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.verophyle.core.client.CoreMenuRegistry;
import com.verophyle.core.client.place.CorePlaceHistoryRegistry;
import com.verophyle.flashcards.client.activity.content.ContentActivityMapper;
import com.verophyle.flashcards.shared.rf.FlashcardsRequestFactory;

@GinModules({FlashcardsGinModule.class})
public interface FlashcardsGinjector extends Ginjector {
  FlashcardsGinjector INSTANCE = GWT.create(FlashcardsGinjector.class);
  
  FlashcardsLogger getLogger();
  CorePlaceHistoryRegistry getPlaceHistoryRegistry();
  
  FlashcardsRequestFactory getRequestFactory(); 
  
  ContentActivityMapper registerContentActivityMapper();
  
  CoreMenuRegistry getMenuRegistry();
}
