/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client;

import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.UmbrellaException;

/**
 * Client-side exception handler.
 */
public class CoreUncaughtExceptionHandler implements UncaughtExceptionHandler {

  @Override
  public void onUncaughtException(Throwable e) {
    e = getException(e);
    Window.alert(e.getMessage());
  }

  private static Throwable getException(Throwable throwable) {
    Throwable result = throwable;
    if (throwable instanceof UmbrellaException && ((UmbrellaException) throwable).getCauses().size() == 1) {
      result = ((UmbrellaException)throwable).getCauses().iterator().next();
    }
    return result;
  }
  
}
