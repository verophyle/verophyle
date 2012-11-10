package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.content.ContentSecondView;

public class ContentSecondActivityImpl extends ContentActivity<Second> implements ContentSecondActivity {
	private PlaceController placeController;
	private ContentSecondView mainView;
	private String text;

	@Inject
	public ContentSecondActivityImpl(PlaceController placeController, ContentSecondView mainView) {
		this.placeController = placeController;
		this.mainView = mainView;
	}
	
	@Override
	public void setPlace(Second place) {
		this.text = place.getText();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		mainView.setText(text);
		mainView.setPresenter(this);
		panel.setWidget(mainView.asWidget());
	}

	@Override
	public void textChanged(String text) {
	}
	
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
