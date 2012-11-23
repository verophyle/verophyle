package com.verophyle.core.client.activity.sidebar;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.CorePlace;

public class SidebarActivityMapper extends CoreActivityMapper<SidebarActivity, CorePlace> {
	
	@Inject
	public SidebarActivityMapper(Provider<CoreActivityProxy<SidebarActivity, CorePlace>> provider) {
		super(provider);
	}
	
}
