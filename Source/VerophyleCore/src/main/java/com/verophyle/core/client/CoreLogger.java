package com.verophyle.core.client;

import java.util.logging.Level;

/**
 * Interface for whatever logger implementation is injected.
 */
public interface CoreLogger {
	void log(Level level, String text);
}
