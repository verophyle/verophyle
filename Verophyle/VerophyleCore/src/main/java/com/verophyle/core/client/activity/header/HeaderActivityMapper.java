package com.verophyle.core.client.activity.header;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.activity.CoreActivityRegistry;
import com.verophyle.core.client.place.CorePlace;

public class HeaderActivityMapper extends CoreActivityMapper<HeaderActivity, CorePlace> {
		
	@Inject
	public HeaderActivityMapper(CoreActivityRegistry<HeaderActivity, CorePlace> registry,
								Provider<CoreActivityProxy<HeaderActivity, CorePlace>> provider, 
								CoreLogger logger) {
		super(registry, provider, logger);
	}

}
