package com.verophyle.core.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface CoreView extends IsWidget {

	public void setPresenter(CorePresenter presenter);
	
	public interface CorePresenter {
	}
	
}
