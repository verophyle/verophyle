package com.verophyle.gae.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.verophyle.core.server.CoreGuiceModule;

public class VerophyleServletContextListener extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(
				new VerophyleServletModule(),
				new CoreGuiceModule()
			);
	}

}
