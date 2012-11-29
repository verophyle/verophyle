package com.verophyle.core.client.activity.header;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.header.HeaderView;

public class HeaderActivityImpl extends CoreActivityImpl<CorePlace, HeaderView> implements HeaderActivity {

	@Inject
	public HeaderActivityImpl(CoreLogger logger, PlaceController placeController, HeaderView headerView) {
		super(logger, placeController, headerView);
	}
	
}
