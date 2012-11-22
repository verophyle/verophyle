package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;
import com.verophyle.core.client.view.content.ContentView;

public abstract class ContentActivityImpl<P extends CorePlace, V extends CoreView> 
	extends CoreActivityImpl<P, V> 
	implements ContentActivity {

	private ContentView contentView;
	private String text;
	
	protected ContentActivityImpl(PlaceController placeController, ContentView coreView) {
		super(placeController, coreView);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		try {
			int counter = Integer.parseInt(text);
			counter += 1;
			text = Integer.toString(counter);
		} catch (NumberFormatException e) {
			text = "-1";
		}
	}

}
