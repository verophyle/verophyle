/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.gae.server;

import java.util.Set;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.domain.CoreUser;

/**
 * User service for the GAE module.
 * 
 * Wraps an App Engine UserService module.
 */
public class GaeUserService implements CoreUserService {
  
  private final UserService userService;
  private final CoreObjectifyService objectifyService;

  @Inject
  public GaeUserService(UserService userService, CoreObjectifyService objectifyService) {
    assert userService != null;
    this.userService = userService;
    this.objectifyService = objectifyService;
  }
  
  @Override
  public String createLoginUrl(String destinationUrl) {
    return userService.createLoginURL(destinationUrl);
  }

  @Override
  public String createLoginUrl(String destinationUrl, String authDomain) {
    return userService.createLoginURL(destinationUrl, authDomain);
  }

  @Override
  public String createLoginUrl(String destinationUrl, String authDomain, String federatedIdentity, Set<String> attributesRequest) {
    return userService.createLoginURL(destinationUrl, authDomain, federatedIdentity, attributesRequest);
  }

  @Override
  public String createLogoutUrl(String destinationUrl) {
    return userService.createLogoutURL(destinationUrl);
  }

  @Override
  public String createLogoutUrl(String destinationUrl, String authDomain) {
    return userService.createLogoutURL(destinationUrl, authDomain);
  }

  @Override
  public CoreUser getCurrentUser() {
    User currentUser = userService.getCurrentUser();
    
    if (currentUser != null) {
      Objectify ofy = objectifyService.ofy();      
      GaeUser existingUser = ofy.load().type(GaeUser.class).filter("user =", currentUser).first().get();

      if (existingUser == null) {
        existingUser = new GaeUser(currentUser);
        ofy.save().entity(existingUser).now();
      }
      
      return existingUser;
    }
    
    return null;
  }

  @Override
  public boolean isUserAdmin() {
    return userService.isUserAdmin();
  }

  @Override
  public boolean isUserLoggedIn() {
    return userService.isUserLoggedIn();
  }
  
}
