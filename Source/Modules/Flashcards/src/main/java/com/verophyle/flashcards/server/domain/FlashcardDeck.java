/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.server.domain;

import javax.validation.constraints.Size;

import com.googlecode.objectify.annotation.EntitySubclass;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.OnSave;
import com.verophyle.core.server.domain.CoreEntity;

@EntitySubclass(index = true)
public class FlashcardDeck extends CoreEntity {
  
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
  // entity boilerplate

  @Size(min = 1, max = 400)
  private String name;
  
  private int num;
  
  public FlashcardDeck() {
    name = "Ozymandias";
    num = 314;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getNum() {
    return num;
  }
  
  public void setNum(int num) {
    this.num = num;
  }
  
}
