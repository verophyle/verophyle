/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.client;

import java.util.logging.Level;

import com.google.gwt.core.client.EntryPoint;
import com.verophyle.flashcards.client.place.Flashcards;

public class FlashcardsEntryPoint implements EntryPoint {
  private static boolean loaded = false;

  @Override
  public void onModuleLoad() {
    FlashcardsGinjector.INSTANCE.getLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
    loaded = true;
  }
  
  public static boolean isLoaded() {
    return loaded;
  }
  
  public static void init() {
    FlashcardsGinjector injector = FlashcardsGinjector.INSTANCE;
    
    injector.getLogger().log(Level.INFO, "FlashcardsEntryPoint.init()");
    
    // register place tokenizer    
    injector.getPlaceHistoryRegistry().register(Flashcards.KEY, new Flashcards.Tokenizer());
    
    // register activity providers
    injector.registerContentActivityMapper();
    
    // register menu providers
    injector.getMenuRegistry().addMenuProvider(new FlashcardsMenuProvider());
  }
}
