package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.content.ContentSecondView;

public class ContentSecondActivityImpl extends ContentActivityImpl<Second> implements ContentSecondActivity {
	private PlaceController placeController;
	private ContentSecondView mainView;

	@Inject
	public ContentSecondActivityImpl(PlaceController placeController, ContentSecondView mainView) {
		this.placeController = placeController;
		this.mainView = mainView;
	}
	
	@Override
	public void setPlace(Second place) {
		setText(place.getText());
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		super.start(panel, eventBus);
		
		mainView.setText(getText());
		mainView.setPresenter(this);
		panel.setWidget(mainView.asWidget());
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
