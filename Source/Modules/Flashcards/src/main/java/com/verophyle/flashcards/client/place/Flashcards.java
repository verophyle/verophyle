/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.client.place;

import com.verophyle.core.client.place.CorePlace;

public class Flashcards extends CorePlace {
  public static final String KEY = "Flashcards";

  @Override
  public String getPlaceKey() {
    return KEY;
  }

  public static class Tokenizer extends CorePlace.Tokenizer<Flashcards> {
    @Override
    public Flashcards getPlace(String token) {
      return new Flashcards();
    }

    @Override
    public String getToken(Flashcards place) {
      return "";
    }    
  }
  
}
