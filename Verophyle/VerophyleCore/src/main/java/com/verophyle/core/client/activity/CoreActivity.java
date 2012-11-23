package com.verophyle.core.client.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.CoreView;
import com.verophyle.core.client.view.CoreView.CorePresenter;

public interface CoreActivity extends Activity, CorePresenter {
	CoreView getView();
	CorePlace getPlace();
	void setPlace(CorePlace place);
	void goTo(Place place);	
}
