/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.gae.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;

/**
 * Client-side logger implementation for the GAE module.
 */
public class VerophyleLogger implements CoreLogger {
  private static Logger logger = Logger.getLogger(GWT.getModuleName());  

  @Inject
  public VerophyleLogger() {
  }
  
  /**
   * Write a message to the log at the given level.
   */
  @Override
  public void log(Level level, String text) {
    logger.log(level, text);
  }

}
