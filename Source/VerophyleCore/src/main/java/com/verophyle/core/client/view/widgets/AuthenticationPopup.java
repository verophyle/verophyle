package com.verophyle.core.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.PopupPanel;

public class AuthenticationPopup extends PopupPanel {

  interface Binder extends UiBinder<FlowPanel, AuthenticationPopup> {}
  private static Binder binder = GWT.create(Binder.class);

  private final String initialUrl;

  @UiField
  Frame frame;

  public AuthenticationPopup(String initialUrl) {
    this.initialUrl = initialUrl;
    this.setAutoHideEnabled(false);
    this.setGlassEnabled(true);

    this.setWidget(binder.createAndBindUi(this));
    frame.setUrl(this.initialUrl);
  }

  public String getUrl() {
    return frame.getUrl();
  }

  public Frame getFrame() {
    return this.frame;
  }

}
