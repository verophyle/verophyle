/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.gae.server;

import com.google.appengine.api.users.User;
import com.google.inject.Inject;
import com.googlecode.objectify.annotation.EntitySubclass;
import com.googlecode.objectify.annotation.Index;
import com.verophyle.core.server.domain.CoreUser;

/**
 * Implementation of {@link CoreUser} for GAE.
 * 
 * Wraps an App Engine user object.
 */
@EntitySubclass(index = true)
public class GaeUser extends CoreUser {

  @Index
  User dataStoreUser;
  
  @Inject
  public GaeUser() {
  }
  
  @Inject
  public GaeUser(User dataStoreUser) {
    assert dataStoreUser != null;
    this.dataStoreUser = dataStoreUser;
    setUserId(this.dataStoreUser.getUserId());
  }
  
  public User getUser() {
    return dataStoreUser;
  }
    
  @Override
  public String getAuthDomain() {
    return dataStoreUser.getAuthDomain();
  }

  @Override
  public String getEmail() {
    return dataStoreUser.getEmail();
  }

  @Override
  public String getFederatedIdentity() {
    return dataStoreUser.getFederatedIdentity();
  }

  @Override
  public String getNickname() {
    return dataStoreUser.getNickname();
  }

  @Override
  public int hashCode() {
    return dataStoreUser != null ? dataStoreUser.hashCode() : 0;
  }
  
  @Override
  public int compareTo(CoreUser user) {
    if (user instanceof GaeUser) {
      return this.dataStoreUser.compareTo(((GaeUser)user).dataStoreUser);
    }
    throw new IllegalArgumentException("Attempted to compare a GaeUser to a different subclass of CoreUser.");
  }

  @Override
  public String toString() {
    return "GaeUser[" + (dataStoreUser != null ? dataStoreUser.toString() : "<null") + "]";
  }
  
}
