package com.verophyle.core.client.activity.footer;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class FooterActivityManager extends ActivityManager {
	
	@Inject
	public FooterActivityManager(FooterActivityMapper mapper, EventBus eventBus) {
		super(mapper, eventBus);
	}

}
