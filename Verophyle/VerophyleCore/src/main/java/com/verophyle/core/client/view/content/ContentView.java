package com.verophyle.core.client.view.content;

import com.google.gwt.user.client.ui.IsWidget;

public interface ContentView extends IsWidget {
	String getText();
	void setText(String text);

	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void textChanged(String text);
	}
}
