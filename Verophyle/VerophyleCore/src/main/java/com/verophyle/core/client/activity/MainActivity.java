package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.verophyle.core.client.TempFactory;
import com.verophyle.core.client.place.MainPlace;
import com.verophyle.core.client.view.MainView;

public class MainActivity extends AbstractActivity implements MainView.Presenter {

	private TempFactory tempFactory;
	private String text;
	
	public MainActivity(MainPlace mainPlace, TempFactory tempFactory) {
		this.tempFactory = tempFactory;
		this.text = mainPlace.getText();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		MainView mainView = tempFactory.getMainView();
		mainView.setText(text);
		mainView.setPresenter(this);
		panel.setWidget(mainView.asWidget());
	}

}
