/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnSave;

@Entity
public class CoreUser extends CoreEntity implements Comparable<CoreUser> {
  
  // entity boilerplate
  @Id
  Long id;
  
  Integer version = 0;

  @OnSave
  @Override
  protected void onSave() {
    version++;
  }
  
  @Override
  public Long getId() {
    return id;
  }
  
  @Override
  public void setId(Long id) {
    this.id = id;
  }
  
  @Override
  public Integer getVersion() {
    return version;
  }
  
  @Override
  public void setVersion(Integer version) {
    this.version = version;
  }
  
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
