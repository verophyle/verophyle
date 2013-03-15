/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.footer;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.footer.FooterView;

/**
 * Implementation of the footer activity.
 */
public class FooterActivityImpl extends CoreActivityImpl<CorePlace, FooterView> implements FooterView.Presenter, FooterActivity {

  @Inject
  public FooterActivityImpl(CoreLogger logger, PlaceController placeController, FooterView footerView) {
    super(logger, placeController, footerView);
  }
  
}
