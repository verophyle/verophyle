/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.content;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Activity manager for Content activities.
 */
public class ContentActivityManager extends ActivityManager {

  @Inject
  public ContentActivityManager(ContentActivityMapper mapper, EventBus eventBus) {
    super(mapper, eventBus);
  }

}
