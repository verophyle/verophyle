/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.activity.content;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.content.ContentSecondView;

public class ContentSecondActivityImpl extends ContentActivityImpl<Second, ContentSecondView> implements ContentSecondActivity {

  @Inject
  public ContentSecondActivityImpl(CoreLogger logger, PlaceController placeController, ContentSecondView mainView) {
    super(logger, placeController, mainView);
  }
  
}
