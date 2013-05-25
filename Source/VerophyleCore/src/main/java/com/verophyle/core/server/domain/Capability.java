/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.verophyle.core.shared.Permission;

@Entity
public class Capability extends CoreEntity {  
  
  // capability functions
  @Index
  String className;
  
  @Index
  String identifier;
  
  EnumSet<Permission> permissions;
  
  public String getClassName() {
    return className;
  }
  
  public void setClassName(String className) {
    this.className = className;
  }
  
  public String getIdentifier() {
    return identifier;
  }
  
  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
  
  public Set<Permission> getPermissions() {
    return Collections.unmodifiableSet(permissions);
  }
  
  public void setPermissions(EnumSet<Permission> permissions) {
    this.permissions.clear();
    this.permissions.addAll(permissions);
  }
  
}
