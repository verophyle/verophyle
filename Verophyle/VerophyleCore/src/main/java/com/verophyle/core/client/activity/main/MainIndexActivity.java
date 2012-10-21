package com.verophyle.core.client.activity.main;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivity;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.main.MainIndexView;
import com.verophyle.core.client.view.main.MainView;

public class MainIndexActivity extends CoreActivity<Index> implements MainView.Presenter {
	private PlaceController placeController;
	private MainIndexView mainView;
	private String text;

	@Inject
	public MainIndexActivity(PlaceController placeController, MainIndexView mainView) {
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
