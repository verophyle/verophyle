package com.verophyle.core.client;

import java.util.List;

import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.widgets.CoreSidebarMenu;

public interface CoreMenuProvider {
  List<CoreSidebarMenu> getSidebarMenus(CorePlace place);
}
