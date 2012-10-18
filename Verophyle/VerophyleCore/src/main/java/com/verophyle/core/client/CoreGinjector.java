package com.verophyle.core.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.verophyle.core.client.view.MainView;

@GinModules({CoreGinModule.class})
public interface CoreGinjector extends Ginjector {
	EventBus getEventBus();
	PlaceController getPlaceController();
	MainView getMainView();
}
