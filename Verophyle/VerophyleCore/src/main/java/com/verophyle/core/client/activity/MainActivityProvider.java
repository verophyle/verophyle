package com.verophyle.core.client.activity;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.verophyle.core.client.view.MainView;

public class MainActivityProvider implements AsyncProvider<MainActivity> {
	private PlaceController placeController;
	private MainView mainView;

	@Inject
	public MainActivityProvider(PlaceController placeController, MainView mainView) {
		this.placeController = placeController;
		this.mainView = mainView;
	}
	
	@Override
	public MainActivity get() {
		return new MainActivity(placeController, mainView);
	}

	@Override
	public void get(AsyncCallback<? super MainActivity> callback) {
		GWT.runAsync(new RunAsyncCallback() {

			@Override
			public void onFailure(Throwable reason) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess() {
				// TODO Auto-generated method stub
				
			}
			
		})
	}

}
