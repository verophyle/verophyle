/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.activity.header;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class HeaderActivityManager extends ActivityManager {

	@Inject
	public HeaderActivityManager(HeaderActivityMapper mapper, EventBus eventBus) {
		super(mapper, eventBus);
	}

}
