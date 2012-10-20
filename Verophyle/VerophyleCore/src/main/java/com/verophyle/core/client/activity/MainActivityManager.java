package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class MainActivityManager extends ActivityManager {

	@Inject
	public MainActivityManager(MainActivityMapper mapper, EventBus eventBus) {
		super(mapper, eventBus);
	}

}
