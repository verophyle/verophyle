/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoreMenuRegistryImpl implements CoreMenuRegistry {
  
  private static List<CoreMenuProvider> menuProviders = new ArrayList<CoreMenuProvider>();

  @Override
  public List<CoreMenuProvider> getMenuProviders() {
    return Collections.unmodifiableList(menuProviders);
  }

  @Override
  public void addMenuProvider(CoreMenuProvider menuProvider) {
    if (!menuProviders.contains(menuProvider))
      menuProviders.add(menuProvider);
  }

}
