/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;
import com.verophyle.core.shared.NotImplementedException;

@Entity
public class CoreUser extends CoreEntity {
  
  // entity boilerplate
  @Id
  Long id;
  
  Integer version = 0;

  @OnSave
  @Override
  void onSave() {
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
  // entity boilerplate

  public int compareTo(CoreUser user) {
    throw new NotImplementedException();
  }
  
  public boolean equals(Object object) {    
    throw new NotImplementedException();
  }
  
  public String getAuthDomain() {
    throw new NotImplementedException();
  }
  
  public String getEmail() {
    throw new NotImplementedException();
  }
  
  public String getFederatedIdentity() {
    throw new NotImplementedException();
  }
  
  public String getNickname() {
    throw new NotImplementedException();
  }
  
  public String getUserId() {
    throw new NotImplementedException();
  }
  
  @Override
  public int hashCode() {
    throw new NotImplementedException();
  }
  
  @Override
  public String toString() {
    throw new NotImplementedException();
  }
  
}
