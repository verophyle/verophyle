package com.verophyle.core.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface AppView extends IsWidget {
	
	public AcceptsOneWidget getHeader();	
	public AcceptsOneWidget  getSidebar();	
	public AcceptsOneWidget getContent();
	public AcceptsOneWidget getFooter();
	
	public void setPresenter(Presenter presenter);

	public interface Presenter {
	}
	
}
