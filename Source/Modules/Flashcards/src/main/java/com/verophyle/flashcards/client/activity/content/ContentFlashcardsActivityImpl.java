/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.client.activity.content;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.flashcards.client.FlashcardsLogger;
import com.verophyle.flashcards.client.place.Flashcards;
import com.verophyle.flashcards.client.view.content.ContentFlashcardsView;

public class ContentFlashcardsActivityImpl extends CoreActivityImpl<Flashcards, ContentFlashcardsView> implements ContentFlashcardsActivity {

  @Inject
  protected ContentFlashcardsActivityImpl(FlashcardsLogger logger, PlaceController placeController, ContentFlashcardsView coreView) {
    super(logger, placeController, coreView);
  }

}
