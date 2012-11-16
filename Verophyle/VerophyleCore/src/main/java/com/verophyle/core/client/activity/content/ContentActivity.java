package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.activity.CoreActivity;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.content.ContentView;

public abstract class ContentActivity<P extends CorePlace> implements CoreActivity<P>, ContentView.Presenter {

	private String text;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String mayStop() {
		return null;
	}

	public void onCancel() {
	}

	public void onStop() {
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		try {
			int counter = Integer.parseInt(text);
			counter += 1;
			text = Integer.toString(counter);
		} catch (NumberFormatException e) {
			text = "-1";
		}
	}

	public void setPlace(P place) {
	}

	public void goTo(Place place) {
	}

}
