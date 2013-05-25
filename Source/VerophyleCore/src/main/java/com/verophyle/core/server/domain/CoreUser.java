/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class CoreUser extends CoreEntity implements Comparable<CoreUser> {
  
  // user functions
  @Index
  String userId;
  
  public String getAuthDomain() {
    throw new UnsupportedOperationException();
  }
  
  public String getEmail() {
    throw new UnsupportedOperationException();
  }
  
  public String getFederatedIdentity() {
    throw new UnsupportedOperationException();
  }
  
  public String getNickname() {
    throw new UnsupportedOperationException();
  }
  
  public String getUserId() {
    return userId;
  }
  
  protected void setUserId(String userId) {
    this.userId = userId;
  }
  
  // object functions
  @Override
  public int hashCode() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public int compareTo(CoreUser user) {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public boolean equals(Object object) {    
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String toString() {
    throw new UnsupportedOperationException();
  }
  
}
