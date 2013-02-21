/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;

public class AppViewImpl extends CoreViewImpl implements AppView {

  interface Binder extends UiBinder<DockLayoutPanel, AppViewImpl> { }
  private static Binder binder = GWT.create(Binder.class);
  
  @UiField DockLayoutPanel topLayoutPanel;
  
  @UiField ResizeLayoutPanel header;
  @UiField ResizeLayoutPanel footer;
  @UiField ResizeLayoutPanel sidebar;
  @UiField ResizeLayoutPanel content;

  @Inject
  public AppViewImpl(CoreLogger logger, CoreResources res) {
    super(logger, res);
    initWidget(binder.createAndBindUi(this));
  }
  
  @Override
  public AcceptsOneWidget getHeader() {
    return header;
  }

  @Override
  public AcceptsOneWidget getSidebar() {
    return sidebar;
  }

  @Override
  public AcceptsOneWidget getContent() {
    return content;
  }

  @Override
  public AcceptsOneWidget getFooter() {
    return footer;
  }

}
