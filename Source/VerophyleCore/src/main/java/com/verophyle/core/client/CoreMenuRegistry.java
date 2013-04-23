package com.verophyle.core.client;

import java.util.List;

public interface CoreMenuRegistry {

  List<CoreMenuProvider> getMenuProviders();
  void addMenuProvider(CoreMenuProvider menuProvider);
  
}
