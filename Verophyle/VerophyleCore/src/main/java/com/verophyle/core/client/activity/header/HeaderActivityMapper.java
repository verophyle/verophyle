package com.verophyle.core.client.activity.header;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.place.CorePlace;

public class HeaderActivityMapper extends CoreActivityMapper<HeaderActivity, CorePlace> {
		
	@Inject
	public HeaderActivityMapper(Provider<CoreActivityProxy<HeaderActivity, CorePlace>> provider) {
		super(provider);
	}

}
