/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.verophyle.core.client.view.CoreView.CorePresenter;

public interface AppView extends IsWidget {
  
  public AcceptsOneWidget getHeader();  
  public AcceptsOneWidget getSidebar();  
  public AcceptsOneWidget getContent();
  public AcceptsOneWidget getFooter();
  
  public interface Presenter extends CorePresenter {
  }
  
}
