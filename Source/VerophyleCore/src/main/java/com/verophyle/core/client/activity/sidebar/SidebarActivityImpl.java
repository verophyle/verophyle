/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client.activity.sidebar;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.CoreMenuProvider;
import com.verophyle.core.client.CoreMenuRegistry;
import com.verophyle.core.client.activity.CoreActivityImpl;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.sidebar.SidebarView;
import com.verophyle.core.client.view.widgets.CoreSidebarMenu;

public class SidebarActivityImpl extends CoreActivityImpl<CorePlace, SidebarView> implements SidebarView.Presenter, SidebarActivity {
  
  private final CoreMenuRegistry menuRegistry;
  private final SidebarView sidebarView;
  
  @Inject
  public SidebarActivityImpl(CoreLogger logger, PlaceController placeController, CoreMenuRegistry menuRegistry, SidebarView sidebarView) {
    super(logger, placeController, sidebarView);
    this.menuRegistry = menuRegistry;
    this.sidebarView = sidebarView;
  }
  
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    super.start(panel, eventBus);
    
    for (CoreMenuProvider menuProvider : menuRegistry.getMenuProviders()) {
      for (CoreSidebarMenu menu : menuProvider.getSidebarMenus(getPlace())) {
        sidebarView.getPanel().add(menu);
      }
    }
  }
  
}
