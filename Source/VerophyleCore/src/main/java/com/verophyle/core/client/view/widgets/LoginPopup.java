package com.verophyle.core.client.view.widgets;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.PopupPanel;

public class LoginPopup extends Composite {

  interface Binder extends UiBinder<PopupPanel, LoginPopup> {}
  private static Binder binder = GWT.create(Binder.class);

  private final URL initialUrl;

  @UiField
  PopupPanel popup;

  @UiField
  Frame frame;

  public LoginPopup(URL initialUrl) {
    this.initialUrl = initialUrl;

    initWidget(binder.createAndBindUi(this));
    frame.setUrl(this.initialUrl.toExternalForm());
  }

  public URL getUrl() {
    try {
      return new URL(frame.getUrl());
    } catch (final MalformedURLException e) {
      return null;
    }
  }

}
