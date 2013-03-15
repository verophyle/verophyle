/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.resources;

import com.google.gwt.resources.client.CssResource;

public interface CoreCssResource extends CssResource {
  String COMPLEMENTARY3();  
  String FONT_MED();

  String vertical();
  String horizontal();
  String horizontalScroll();
  String verticalScroll();
  
  String header();
  String headerLogo();
  String headerLogin();
  String headerLoginAuth();
  String headerLoginInfo();
  String headerLoginButton();
  String headerLoginImage();
  
  String sidebar();
  String sidebarItem();
  
  String footer();
  
  String content();
  String contentBody();
  
  String title();
  String para();
  
  String coreButton();
  String coreTextBox();
  String initial();
}
