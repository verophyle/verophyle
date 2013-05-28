/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf.identity;

import java.util.Date;

import org.slf4j.Logger;

import com.google.inject.Inject;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.verophyle.core.server.CoreObjectifyService;
import com.verophyle.core.server.CoreUserService;
import com.verophyle.core.server.domain.AuthEvent;
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
    final Objectify ofy = objectifyService.ofy();

    // get current user
    CoreUser currentUser;
    if (userService.isUserLoggedIn() && (currentUser = userService.getCurrentUser()) != null) {
      logger.info("current user is {}", currentUser);

      // search for identities with that user
      Key<CoreUser> key = Key.create(CoreUser.class, currentUser.getId());
      Identity identity = ofy.load()
          .type(Identity.class)
          .filter("userRefs", key)
          .first().now();

      if (identity != null) {
        logger.info("found identity " + identity.getNickname());
        return identity;
      }

      // no existing identity found; create new identity for this user
      String nickname = currentUser.getNickname();
      if (nickname.equals(Identity.GUEST_NICKNAME))
        nickname = nickname + " n00b";

      logger.info("creating new identity {}", nickname);

      identity = new Identity();
      identity.setNickname(currentUser.getNickname());
      identity.addUser(currentUser);
      ofy.save().entity(identity).now();

      return identity;
    } else {  
      // get or create guest user
      logger.info("no user logged in; searching for {}", Identity.GUEST_NICKNAME);
      Identity guest = ofy.load()
          .type(Identity.class)
          .filter("nickname", Identity.GUEST_NICKNAME)
          .first().now();
  
      if (guest == null) {
        logger.info("no guest identity; creating {}", Identity.GUEST_NICKNAME);
  
        guest = new Identity();
        guest.setNickname(Identity.GUEST_NICKNAME);
  
        guest.setAnonymous(true);
        ofy.save().entity(guest).now();
      } else {
        logger.info("found guest {}", guest.getNickname());
      }
  
      return guest;
    }
  }
  
  @Override
  public synchronized Identity getLoggedInIdentity(String nonce) {
    if (nonce == null || nonce.isEmpty())
      return null;
    
    Objectify ofy = objectifyService.ofy();

    logger.info("looking up nonce {}", nonce);
    AuthEvent authEvent = ofy.load()
        .type(AuthEvent.class)
        .filter("nonce", nonce)
        .first().now();
    
    Date now = new Date();
    Date cutoff = new Date(now.getTime() - (30 * 1000));
    if (authEvent == null) {
      logger.info("no auth event for {}", nonce);
      return null;
    } else if (authEvent.getDate().before(cutoff)) {
      logger.info("auth event {} has expired ({} < {})", nonce, authEvent.getDate(), cutoff);
      return null;
    } else {
      return getCurrentIdentity();
    }
  }

  @Override
  public String getGravatarImageUrl(long identityId) {
    final Objectify ofy = objectifyService.ofy();
    
    Key<Identity> key = Key.create(Identity.class, identityId);
    Identity identity = ofy.load()
        .type(Identity.class)
        .filterKey(key)
        .first().now();
    
    if (identity != null) {
      for (final CoreUser coreUser : identity.getUsers()) {
        final String email = coreUser.getEmail();
        if (email != null && !email.isEmpty())
          return makeGravatarImageUrl(email);
      }      
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
