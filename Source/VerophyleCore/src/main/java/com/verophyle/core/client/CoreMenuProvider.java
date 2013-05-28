/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client;

import java.util.List;

import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.widgets.CoreSidebarMenu;

public interface CoreMenuProvider {
  List<CoreSidebarMenu> getSidebarMenus(CorePlace place);
}
