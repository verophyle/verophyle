package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.CorePlace;

public class CoreActivityProxy<A extends CoreActivity, P extends CorePlace> implements Activity {
	
	private AsyncProvider<A> activityProvider;
	private CorePlace place = null;
	private CoreActivity activity = null;
	boolean cancelled = false;
	
	@Inject
	public CoreActivityProxy(AsyncProvider<A> activityProvider) {
		this.activityProvider = activityProvider;
	}

	public void setPlace(CorePlace place) {
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
			activityProvider.get(new AsyncCallback<A>() {

				@Override
				public void onFailure(Throwable caught) {
				}

				@Override
				public void onSuccess(A result) {
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
