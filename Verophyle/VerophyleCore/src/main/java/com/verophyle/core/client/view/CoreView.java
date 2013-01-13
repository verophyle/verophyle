package com.verophyle.core.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface CoreView extends IsWidget {

	public void setPresenter(CorePresenter presenter);
	
	public interface CorePresenter {
		void goTo(Place place);
	}
	
}
