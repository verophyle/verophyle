package com.verophyle.core.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface MainView extends IsWidget {
	void setPresenter(Presenter presenter);
	
	String getText();
	void setText(String text);

	public interface Presenter {
	}
}
