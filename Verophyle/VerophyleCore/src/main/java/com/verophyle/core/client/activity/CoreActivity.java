package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;

public abstract class CoreActivity<T extends Place> extends AbstractActivity {
	abstract void setPlace(T place);
}
