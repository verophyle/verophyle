package com.verophyle.gae.server;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.shared.domain.CoreEntity;

public class GaeObjectifyService extends CoreObjectifyService {

	public GaeObjectifyService() {
		super();
	}
	
	@Override
	public Objectify ofy() {
		return ObjectifyService.ofy();
	}

	@Override
	protected void register(Class<? extends CoreEntity> clazz) {
		ObjectifyService.register(clazz);
	}

}
