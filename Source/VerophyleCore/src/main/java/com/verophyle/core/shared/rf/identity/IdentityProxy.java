/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.shared.rf.identity;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.verophyle.core.server.domain.Identity;
import com.verophyle.core.server.rf.identity.IdentityLocater;
import com.verophyle.core.shared.rf.CoreUserProxy;

@ProxyFor(value = Identity.class, locator = IdentityLocater.class)
public interface IdentityProxy extends EntityProxy {
  Long getId();
  Integer getVersion();

  String getNickname();
  void setNickname(String nickname);
  
  List<CoreUserProxy> getUserList();
  
  boolean isAnonymous();
  boolean isAdministrator();
}
