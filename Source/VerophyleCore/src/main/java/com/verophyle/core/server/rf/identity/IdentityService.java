/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf.identity;

import com.verophyle.core.server.domain.Identity;

public interface IdentityService {
  Identity getCurrentIdentity();  
  String getGravatarImageUrl(Identity identity);
  
  String getLoginUrl(String currentUrl);
  String getLogoutUrl(String currentUrl);
}
