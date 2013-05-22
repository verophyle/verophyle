/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.CorePlace;

/**
 * Proxy for activities.
 *
 * We don't actually create activities immediately they are needed.  We create these proxies,
 * which allows the activity code to be loaded as needed rather than all at once.
 *
 * @param <A> Activity class.
 * @param <P> Place class.
 */
public class CoreActivityProxy<A extends CoreActivity, P extends CorePlace> implements Activity {

  private final AsyncProvider<A> activityProvider;
  private CorePlace place = null;
  private CoreActivity activity = null;
  boolean cancelled = false;

  @Inject
  public CoreActivityProxy(AsyncProvider<A> activityProvider) {
    this.activityProvider = activityProvider;
  }

  /**
   * Sets the activity's place.
   * @param place
   */
  public void setPlace(CorePlace place) {
    this.place = place;

    if (activity != null)
      activity.setCorePlace(place);
  }

  /**
   * Called to get a message to ask the user if the activity can be stopped.
   *
   * Doesn't do anything if the actual activity has not been loaded yet.
   */
  @Override
  public String mayStop() {
    if (activity != null)
      return activity.mayStop();
    return null;
  }

  /**
   * Called when the activity is cancelled.
   */
  @Override
  public void onCancel() {
    if (activity != null)
      activity.onCancel();
    cancelled = true;
  }

  /**
   * Called when the activity is stopped.
   */
  @Override
  public void onStop() {
    if (activity != null)
      activity.onStop();
  }

  @Override
  public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
    if (activity != null) {
      activity.start(panel,  eventBus);
    } else {
      activityProvider.get(new AsyncCallback<A>() {

        @Override
        public void onSuccess(A result) {
          activity = result;

          if (!cancelled) {
            activity.setCorePlace(place);
            activity.start(panel, eventBus);
          } else {
            activity.onCancel();
          }
        }

        @Override
        public void onFailure(Throwable caught) {
        }

      });
    }
  }

}
