package com.verophyle.core.client.activity.sidebar;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.sidebar.SidebarView;

public class SidebarActivityImpl extends CoreActivityImpl<CorePlace, SidebarView> implements SidebarView.Presenter, SidebarActivity {
	
	@Inject
	public SidebarActivityImpl(PlaceController placeController, SidebarView sidebarView) {
		super(placeController, sidebarView);
	}
	
}
