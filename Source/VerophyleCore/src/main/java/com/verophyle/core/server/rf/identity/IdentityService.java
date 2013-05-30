/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf.identity;

import com.verophyle.core.server.domain.AuthIdentityResult;
import com.verophyle.core.server.domain.Identity;

public interface IdentityService {
  Identity getCurrentIdentity();
  AuthIdentityResult getLoggedInIdentity(String nonce);

  String getGravatarImageUrl(long identityId);
  
  String getLoginUrl(String currentUrl);
  String getLogoutUrl(String currentUrl);
}
