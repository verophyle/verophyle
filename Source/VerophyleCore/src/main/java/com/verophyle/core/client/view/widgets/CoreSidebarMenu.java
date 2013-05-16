/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Tree;

public class CoreSidebarMenu extends Composite {

  interface Binder extends UiBinder<FlowPanel, CoreSidebarMenu> {}
  private static Binder binder = GWT.create(Binder.class);

  @UiField
  Tree tree;
  
  public CoreSidebarMenu() {
    initWidget(binder.createAndBindUi(this));
  }

  public Tree getTree() {
    return tree;
  }
  
}
