package com.verophyle.core.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Main;
import com.verophyle.core.client.view.MainView;

public class MainActivity extends CoreActivity<Main> implements MainView.Presenter {
	private PlaceController placeController;
	private MainView mainView;
	private String text;

	@Inject
	public MainActivity(PlaceController placeController, MainView mainView) {
		this.placeController = placeController;
		this.mainView = mainView;
	}
	
	@Override
	public void setPlace(Main mainPlace) {
		this.text = mainPlace.getText();
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
