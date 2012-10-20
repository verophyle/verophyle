package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class ActivityCallback<T extends Activity> implements AsyncCallback<T> {

	private T result = null;
	private Throwable error = null;
	
	public boolean hasResult() {
		return result != null;
	}
	
	public T getResult() {
		return result;
	}
	
	public Throwable getError() {
		return error;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		this.error = caught;
	}
	
	@Override
	public void onSuccess(T result) {
		this.result = result;
	}
		
}
