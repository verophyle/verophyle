/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;

public abstract class CoreEntity {
  @Id
  Long id;
  
  Integer version = 0;

  @OnSave
  protected void onSave() {
    version++;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Integer getVersion() {
    return version;
  }
  
  public void setVersion(Integer version) {
    this.version = version;
  }
  
}
