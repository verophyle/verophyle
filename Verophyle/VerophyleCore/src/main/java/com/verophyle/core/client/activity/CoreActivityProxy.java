package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class CoreActivityProxy<T extends CoreActivity<P>, P extends Place> implements Activity {
	
	private AsyncProvider<T> activityProvider;
	private P place = null;
	private T activity = null;
	boolean cancelled = false;
	
	@Inject
	public CoreActivityProxy(AsyncProvider<T> activityProvider) {
		this.activityProvider = activityProvider;
	}

	public void setPlace(P place) {
		this.place = place;
		
		if (activity != null)
			activity.setPlace(place);
	}
	
	@Override
	public String mayStop() {
		if (activity != null)
			return activity.mayStop();
		return null;
	}

	@Override
	public void onCancel() {
		if (activity != null)
			activity.onCancel();
		cancelled = false;
	}

	@Override
	public void onStop() {
		if (activity != null)
			activity.onStop();
	}

	@Override
	public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
		if (activity != null) {
			activity.start(panel,  eventBus);
		} else {
			activityProvider.get(new AsyncCallback<T>() {

				@Override
				public void onFailure(Throwable caught) {
				}

				@Override
				public void onSuccess(T result) {
					activity = result;
					if (!cancelled) {
						activity.setPlace(place);
						activity.start(panel, eventBus);
					}
				}
				
			});
		}
	}

}
