package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class CoreServiceLocator implements ServiceLocator {

	private final Injector injector;
	
	@Inject
	protected CoreServiceLocator(final Injector injector) {
		super();
		this.injector = injector;
	}
		
	@Override
	public Object getInstance(Class<?> clazz) {
		return injector.getInstance(clazz);
	}

}
