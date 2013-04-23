package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.verophyle.core.server.domain.CoreUser;

public class CoreUserLocator extends CoreLocator<CoreUser> {

  @Inject
  public CoreUserLocator(Injector injector) {
    super(injector, CoreUser.class);
  }

}
