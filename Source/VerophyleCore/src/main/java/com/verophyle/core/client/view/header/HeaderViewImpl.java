/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;
import com.verophyle.core.client.widgets.IdentityAuthentication;
import com.verophyle.core.shared.CoreMessages;

public class HeaderViewImpl extends CoreViewImpl implements HeaderView {

  interface Binder extends UiBinder<FlowPanel, HeaderViewImpl> { }
  private static Binder binder = GWT.create(Binder.class);

  @UiField
  HTML logo;

  @UiField
  IdentityAuthentication identityAuth;

  CoreMessages messages;

  @Inject
  public HeaderViewImpl(CoreLogger logger, CoreResources res, CoreMessages messages) {
    super(logger, res);
    this.messages = messages;

    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public HTML getLogo() {
    return logo;
  }

  @Override
  public IdentityAuthentication getIdentityAuth() {
    return identityAuth;
  }

}
