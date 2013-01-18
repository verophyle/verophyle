package com.verophyle.gae.server;

import com.google.gwt.logging.server.RemoteLoggingServiceImpl;
import com.google.inject.servlet.ServletModule;
import com.verophyle.core.server.rf.CoreRequestFactoryServlet;

public class VerophyleServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		serve("/Verophyle/remote_logging").with(RemoteLoggingServiceImpl.class);
		serve("/gwtRequest").with(CoreRequestFactoryServlet.class);
	}
	
}
