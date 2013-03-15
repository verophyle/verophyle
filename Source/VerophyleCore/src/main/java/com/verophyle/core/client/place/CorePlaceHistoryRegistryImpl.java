/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.place;

import java.util.HashMap;

import com.google.gwt.place.shared.Place;

public class CorePlaceHistoryRegistryImpl implements CorePlaceHistoryRegistry {
  private final HashMap<String, CorePlace.Tokenizer<? extends Place>> tokenizers = 
      new HashMap<String, CorePlace.Tokenizer<? extends Place>>();
  
  public void register(String key, CorePlace.Tokenizer<? extends Place> tokenizer) {
    tokenizers.put(key, tokenizer);
  }
  
  public CorePlace.Tokenizer<? extends Place> getTokenizer(String placeKey) {
    return tokenizers.get(placeKey);
  }
  
}
