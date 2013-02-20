/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.content.ContentView;

/**
 * Base class for Content activities.
 * 
 * @param <P> Place class.
 * @param <V> View class.
 */
public abstract class ContentActivityImpl<P extends CorePlace, V extends ContentView> 
	extends CoreActivityImpl<P, V> 
	implements ContentActivity {

	protected ContentActivityImpl(CoreLogger logger, PlaceController placeController, ContentView coreView) {
		super(logger, placeController, coreView);
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
	}

}
