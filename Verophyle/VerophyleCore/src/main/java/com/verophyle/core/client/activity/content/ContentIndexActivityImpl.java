package com.verophyle.core.client.activity.content;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.content.ContentIndexView;

public class ContentIndexActivityImpl extends ContentActivityImpl<Index, ContentIndexView> implements ContentIndexActivity {

	@Inject
	public ContentIndexActivityImpl(PlaceController placeController, ContentIndexView contentView) {
		super(placeController, contentView);
	}
	
}
