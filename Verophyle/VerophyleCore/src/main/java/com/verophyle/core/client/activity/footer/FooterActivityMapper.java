package com.verophyle.core.client.activity.footer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.activity.CoreActivityMapper;
import com.verophyle.core.client.activity.CoreActivityProxy;
import com.verophyle.core.client.place.CorePlace;

public class FooterActivityMapper extends CoreActivityMapper<FooterActivity, CorePlace> {

	@Inject
	public FooterActivityMapper(Provider<CoreActivityProxy<FooterActivity, CorePlace>> provider, CoreLogger logger) {
		super(provider, logger);
	}

}
