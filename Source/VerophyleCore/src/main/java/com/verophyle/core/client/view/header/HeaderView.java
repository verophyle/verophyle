/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view.header;

import com.verophyle.core.client.view.CoreView;
import com.verophyle.core.client.view.widgets.IdentityAuthentication;

public interface HeaderView extends CoreView {
  
  public IdentityAuthentication getIdentityAuth();

  public interface Presenter extends CorePresenter {
    void onLogoClick();
  }

}
