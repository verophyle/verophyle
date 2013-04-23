/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

public abstract class CoreEntity {
  protected abstract void onSave();  
  public abstract Long getId();  
  public abstract void setId(Long id);  
  public abstract Integer getVersion();
  public abstract void setVersion(Integer version);  
}
