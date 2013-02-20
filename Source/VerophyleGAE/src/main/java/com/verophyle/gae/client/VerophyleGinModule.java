/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.gae.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class VerophyleGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(VerophyleLogger.class).in(Singleton.class);
	}

}
