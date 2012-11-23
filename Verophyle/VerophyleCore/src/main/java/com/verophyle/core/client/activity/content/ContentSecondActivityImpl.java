package com.verophyle.core.client.activity.content;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.content.ContentSecondView;

public class ContentSecondActivityImpl extends ContentActivityImpl<Second, ContentSecondView> implements ContentSecondActivity {

	@Inject
	public ContentSecondActivityImpl(PlaceController placeController, ContentSecondView mainView) {
		super(placeController, mainView);
	}
	
}
