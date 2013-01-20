package com.verophyle.gae.server;

import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.verophyle.core.server.rf.CoreRequestFactoryServlet;

public class VerophyleServletModule extends ServletModule {
	
	@Inject
	public VerophyleServletModule() {
		super();
	}

	@Override
	protected void configureServlets() {
		bind(RemoteLoggingServiceImpl.class).in(Singleton.class);
		bind(CoreRequestFactoryServlet.class).in(Singleton.class);
		
		serve("/Verophyle/remote_logging").with(RemoteLoggingServiceImpl.class);
		serve("/gwtRequest").with(CoreRequestFactoryServlet.class);
	}
	
}
