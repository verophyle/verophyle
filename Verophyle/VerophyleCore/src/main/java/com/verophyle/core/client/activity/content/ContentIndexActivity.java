package com.verophyle.core.client.activity.content;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivity;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.content.ContentIndexView;
import com.verophyle.core.client.view.content.ContentView;

public class ContentIndexActivity extends CoreActivity<Index> implements ContentView.Presenter {
	private PlaceController placeController;
	private ContentIndexView mainView;
	private String text;

	@Inject
	public ContentIndexActivity(PlaceController placeController, ContentIndexView mainView) {
		this.placeController = placeController;
		this.mainView = mainView;
	}
	
	@Override
	public void setPlace(Index place) {
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