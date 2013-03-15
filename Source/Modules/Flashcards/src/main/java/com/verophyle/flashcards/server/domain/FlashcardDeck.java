/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.server.domain;

import javax.validation.constraints.Size;

import com.googlecode.objectify.annotation.EntitySubclass;
import com.verophyle.core.server.domain.CoreEntity;

@EntitySubclass(index = true)
public class FlashcardDeck extends CoreEntity {
  
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
