/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.place;

import com.google.gwt.place.shared.Place;

public interface CorePlaceHistoryRegistry {
  void register(String key, CorePlace.Tokenizer<? extends Place> tokenizer);
  CorePlace.Tokenizer<? extends Place> getTokenizer(String placeKey);
}
