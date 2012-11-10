package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

public interface CoreActivity<T extends Place> extends Activity {
	public abstract void setPlace(T place);
	public abstract void goTo(Place place);	
}
