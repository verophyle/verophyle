package com.verophyle.core.client.activity.header;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivity;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.header.HeaderView;

// factor this out if there are any more header activities
public class HeaderActivityImpl implements CoreActivity<CorePlace>, HeaderView.Presenter, HeaderActivity {
	private PlaceController placeController;
	private HeaderView headerView;

	@Inject
	public HeaderActivityImpl(PlaceController placeController, HeaderView headerView) {
		this.placeController = placeController;
		this.headerView = headerView;
	}
	
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
		headerView.setPresenter(this);
		panel.setWidget(headerView.asWidget());
	}

	@Override
	public void textChanged(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlace(CorePlace place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
