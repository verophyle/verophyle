/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.EntitySubclass;
import com.verophyle.core.shared.NotImplementedException;

@EntitySubclass(index = true)
public class CoreUser extends CoreEntity {
  
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
