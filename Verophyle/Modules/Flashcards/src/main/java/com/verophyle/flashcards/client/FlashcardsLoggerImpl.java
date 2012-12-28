package com.verophyle.flashcards.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;

public class FlashcardsLoggerImpl implements CoreLogger {

	private static Logger logger = Logger.getLogger(GWT.getModuleName());
	
	@Inject
	public FlashcardsLoggerImpl() {
	}
	
	@Override
	public void log(Level level, String text) {
		logger.log(level, text);
	}
	
}
