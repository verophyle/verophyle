package com.verophyle.core.client.activity.footer;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.footer.FooterView;

public class FooterActivityImpl extends CoreActivityImpl<CorePlace, FooterView> implements FooterView.Presenter, FooterActivity {

	@Inject
	public FooterActivityImpl(PlaceController placeController, FooterView footerView) {
		super(placeController, footerView);
	}
	
}
