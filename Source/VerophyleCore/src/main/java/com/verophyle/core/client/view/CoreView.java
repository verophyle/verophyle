/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.UIObject;

public interface CoreView extends IsWidget {
  void setPresenter(CorePresenter presenter);
  
  interface CorePresenter {
    void goTo(Place place);
  }
  
  void fadeIn();
  void fadeIn(UIObject uiObject);
  
  void fadeOut();
  void fadeOut(UIObject uiObject);
}
