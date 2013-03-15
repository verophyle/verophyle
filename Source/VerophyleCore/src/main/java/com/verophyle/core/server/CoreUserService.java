/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import java.util.Set;

import com.verophyle.core.server.domain.CoreUser;

public interface CoreUserService {
  String createLoginUrl(String destinationUrl);
  String createLoginUrl(String destinationUrl, String authDomain);
  String createLoginUrl(String destinationUrl, String authDomain, String federatedIdentity, Set<String> attributesRequest);
  String createLogoutUrl(String destinationUrl);
  String createLogoutUrl(String destinationUrl, String authDomain);
  CoreUser getCurrentUser();
  boolean isUserAdmin();
  boolean isUserLoggedIn();
}
