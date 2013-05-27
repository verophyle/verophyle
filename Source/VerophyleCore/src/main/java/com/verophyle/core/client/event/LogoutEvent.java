/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.verophyle.core.client.event.LogoutEvent.LogoutEventHandler;

public class LogoutEvent extends GwtEvent<LogoutEventHandler> {

  public interface LogoutEventHandler extends EventHandler {
    void onLogoutEvent(LogoutEvent event);
  }

  public static Type<LogoutEventHandler> TYPE = new Type<LogoutEventHandler>();

  @Override
  public Type<LogoutEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(LogoutEventHandler handler) {
    handler.onLogoutEvent(this);
  }

}
