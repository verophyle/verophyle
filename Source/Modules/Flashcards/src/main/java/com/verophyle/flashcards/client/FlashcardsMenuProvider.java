package com.verophyle.flashcards.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;
import com.verophyle.core.client.CoreMenuProvider;
import com.verophyle.core.client.place.CorePlace;
import com.verophyle.core.client.view.widgets.CoreSidebarMenu;

public class FlashcardsMenuProvider implements CoreMenuProvider {
  
  private final List<CoreSidebarMenu> menus = new ArrayList<CoreSidebarMenu>();

  @SuppressWarnings("deprecation")
  @Override
  public List<CoreSidebarMenu> getSidebarMenus(CorePlace place) {
    if (menus.size() == 0) {
      CoreSidebarMenu menu = new CoreSidebarMenu();
      menu.getTree().addItem(new TreeItem("Flash Menu"));
      menus.add(menu);
    }
    
    return Collections.unmodifiableList(menus);
  }

}
