/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.verophyle.core.client.event.LoginEvent.LoginEventHandler;

public class LoginEvent extends GwtEvent<LoginEventHandler> {

  public interface LoginEventHandler extends EventHandler {
    void onLoginEvent(LoginEvent event);
  }

  public static Type<LoginEventHandler> TYPE = new Type<LoginEventHandler>();

  @Override
  public Type<LoginEventHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(LoginEventHandler handler) {
    handler.onLoginEvent(this);
  }

}
