package com.verophyle.core.client.view.header;

import com.google.gwt.user.client.ui.IsWidget;

public interface HeaderView extends IsWidget {

	void setPresenter(Presenter presenter);
	
	public interface Presenter {
		void textChanged(String text);
	}

}
