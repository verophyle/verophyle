package com.verophyle.core.client.view.content;

import com.verophyle.core.client.view.CoreView;

public interface ContentView extends CoreView {
	String getText();
	void setText(String text);
	
	interface Presenter extends CorePresenter {
	}
}
