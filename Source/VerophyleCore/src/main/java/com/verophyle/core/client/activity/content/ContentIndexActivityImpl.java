/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.content;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.content.ContentIndexView;

/**
 * Implementation of the Index activity.
 */
public class ContentIndexActivityImpl extends ContentActivityImpl<Index, ContentIndexView> implements ContentIndexActivity {
  
  @Inject
  public ContentIndexActivityImpl(CoreLogger logger, PlaceController placeController, ContentIndexView contentView) {
    super(logger, placeController, contentView);
  }
  
}
