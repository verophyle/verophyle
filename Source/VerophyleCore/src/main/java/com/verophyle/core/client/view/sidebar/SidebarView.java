/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view.sidebar;

import com.google.gwt.user.client.ui.FlowPanel;
import com.verophyle.core.client.view.CoreView;

public interface SidebarView extends CoreView {

  public interface Presenter extends CorePresenter {
  }
  
  public FlowPanel getPanel();  
  
}
