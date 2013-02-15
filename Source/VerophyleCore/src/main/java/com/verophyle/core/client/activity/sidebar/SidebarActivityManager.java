package com.verophyle.core.client.activity.sidebar;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class SidebarActivityManager extends ActivityManager {

	@Inject
	public SidebarActivityManager(SidebarActivityMapper mapper, EventBus eventBus) {
		super(mapper, eventBus);
	}
	
}
