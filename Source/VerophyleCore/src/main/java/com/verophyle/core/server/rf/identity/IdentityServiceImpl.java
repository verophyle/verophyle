/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf.identity;

import org.slf4j.Logger;

import com.google.inject.Inject;
import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.server.domain.Identity;
import com.verophyle.core.shared.Gravatar;

public class IdentityServiceImpl implements IdentityService {

  private final Logger logger;
  private final CoreUserService userService;
  private final CoreObjectifyService objectifyService;
  
  @Inject
  public IdentityServiceImpl(Logger logger, CoreUserService userService, CoreObjectifyService objectifyService) {
    this.userService = userService;
    this.objectifyService = objectifyService;
    this.logger = logger;
  }
  
  @Override
  public synchronized Identity getCurrentIdentity() {
    Objectify ofy = objectifyService.ofy();
    
    // get current user
    CoreUser currentUser;
    if (userService.isUserLoggedIn() && (currentUser = userService.getCurrentUser()) != null) {
      logger.info("current user is " + currentUser.getNickname());
      
      // search for identities with that user
      Identity identity = ofy.load().type(Identity.class)
        .filter("users.userId", currentUser.getUserId()).first().get();
      
      if (identity != null) {
        logger.info("found identity " + identity.getNickname());
        return identity;        
      }
            
      // no existing identity found; create new identity for this user            
      String nickname = currentUser.getNickname();
      if (nickname.equals(Identity.GUEST_NICKNAME))
        nickname = nickname + " n00b";
      
      logger.info("creating new identity " + nickname);
      
      identity = new Identity();
      identity.setNickname(currentUser.getNickname());
      identity.addUser(currentUser);
        
      ofy.save().entity(identity).now();

      return identity;
    }

    // get or create guest user
    logger.info("no user logged in; searching for " + Identity.GUEST_NICKNAME);    
    Identity guest = ofy.load().type(Identity.class)
      .filter("nickname", Identity.GUEST_NICKNAME).first().get();
    
    if (guest == null) {
      logger.info("no guest identity; creating " + Identity.GUEST_NICKNAME);
      
      guest = new Identity();
      guest.setNickname(Identity.GUEST_NICKNAME);
      
      guest.setAnonymous(true);
      ofy.save().entity(guest).now();
    }
    
    return guest;
  }
  
  @Override
  public String getGravatarImageUrl(Identity identity) {
    if (identity == null)
      return null;
    
    for (CoreUser coreUser : identity.getUsers()) {
      String email = coreUser.getEmail();
      if (email != null && !email.isEmpty())
        return makeGravatarImageUrl(email);
    }
    
    return makeGravatarImageUrl("anonymous@verophyle.com");
  }

  private String makeGravatarImageUrl(String email) {
    return "http://www.gravatar.com/avatar/" + Gravatar.getHash(email) + "?r=g";
  }
  
  @Override
  public String getLoginUrl(String currentUrl) {
    return userService.createLoginUrl(currentUrl);
  }

  @Override
  public String getLogoutUrl(String currentUrl) {
    return userService.createLogoutUrl(currentUrl);
  }
  
}
