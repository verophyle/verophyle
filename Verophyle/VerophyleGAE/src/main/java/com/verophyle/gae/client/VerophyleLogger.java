package com.verophyle.gae.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;

public class VerophyleLogger implements CoreLogger {
	private static Logger logger = Logger.getLogger(GWT.getModuleName());	

	@Inject
	public VerophyleLogger() {
	}
	
	@Override
	public void log(Level level, String text) {
		logger.log(level, text);
	}

}
