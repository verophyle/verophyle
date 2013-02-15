package com.verophyle.core.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;

public class CoreLoggerImpl implements CoreLogger {
	
	private static Logger logger = Logger.getLogger(GWT.getModuleName());

	@Inject
	public CoreLoggerImpl() {
	}
	
	@Override
	public void log(Level level, String text) {
		logger.log(level, text);
	}

}
