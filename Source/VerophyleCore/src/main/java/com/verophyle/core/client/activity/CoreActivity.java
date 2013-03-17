/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;
import com.verophyle.core.client.view.CoreView.CorePresenter;

/**
 * Interface that all activities in the Verophyle project implement.
 * 
 * Activities are light-weight objects that are created on a change of place.
 * They also are the presenters for the more heavy-weight view objects.
 */
public interface CoreActivity extends Activity, CorePresenter {
  CoreView getView();
  CorePlace getPlace();
  void setPlace(CorePlace place);
}
