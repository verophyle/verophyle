package com.verophyle.core.client.activity.header;

import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.place.CorePlace;

public class HeaderActivityMapper extends CoreActivityMapper<HeaderActivity, CorePlace> {
		
	@Inject
	public HeaderActivityMapper(CoreGinjector injector) {
		super(injector);
	}

}
