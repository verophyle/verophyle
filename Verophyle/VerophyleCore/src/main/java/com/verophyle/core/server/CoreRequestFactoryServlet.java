package com.verophyle.core.server;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class CoreRequestFactoryServlet extends RequestFactoryServlet {
	private static final long serialVersionUID = 1L;

	static class CoreExceptionHandler implements ExceptionHandler {
		@Override
		public ServerFailure createServerFailure(Throwable throwable) {
			return new ServerFailure(throwable.getMessage(), throwable.getClass().getName(), null, true);
		}
	}
	
	public CoreRequestFactoryServlet() {
		super(new CoreExceptionHandler());
	}
}
