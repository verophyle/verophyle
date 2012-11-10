package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.activity.CoreActivity;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.content.ContentView;

public class ContentActivity<P extends CorePlace> implements CoreActivity<P>, ContentView.Presenter {

	@Override
	public String mayStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textChanged(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlace(P place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}

}
