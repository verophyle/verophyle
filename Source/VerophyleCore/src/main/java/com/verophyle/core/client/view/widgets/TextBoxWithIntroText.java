/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreGinjector;

public class TextBoxWithIntroText extends TextBox {
  
  private boolean initialText = true;
  private static final String coreTextBoxStyle = CoreGinjector.INSTANCE.getCoreResources().css().coreTextBox();
  private static final String initialStyle = CoreGinjector.INSTANCE.getCoreResources().css().initial();
  
  @Inject
  public TextBoxWithIntroText() {
    super();
    
    this.removeStyleName("gwt-TextBox");
    
    this.addStyleName(coreTextBoxStyle);
    this.addStyleName(initialStyle);

    addClickHandler(clickHandler);
    addKeyPressHandler(keyPressHandler);
  }
  
  private void Reset() {
    if (initialText) {
      setText("");
      this.removeStyleName(initialStyle);
      initialText = false;
    }
  }
  
  private static final ClickHandler clickHandler = new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
      TextBoxWithIntroText tb = (TextBoxWithIntroText) event.getSource();
      tb.Reset();
    }
  };
  
  private static final KeyPressHandler keyPressHandler = new KeyPressHandler() {
    @Override
    public void onKeyPress(KeyPressEvent event) {
      TextBoxWithIntroText tb = (TextBoxWithIntroText) event.getSource();
      tb.Reset();
    }    
  };
  
}
