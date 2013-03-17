/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.EntitySubclass;
import com.googlecode.objectify.annotation.Index;

@EntitySubclass(index = true)
public class Identity extends CoreEntity {
  
  public static final String GUEST_NICKNAME = "Anonymous";

  @Index
  String nickname;
  
  @Index
  List<Ref<CoreUser>> users = new ArrayList<Ref<CoreUser>>();
  
  boolean anonymous;
  boolean administrator;
  
  public Identity() {
  }
  
  public String getNickname() {
    if (nickname != null && !nickname.isEmpty())
      return nickname;

    for (Ref<CoreUser> user : users) {
      String userNick = user.get().getNickname();
      if (userNick != null && !userNick.isEmpty())
        return userNick;
    }
    
    return "? unknown user ?";
  }
  
  public void setNickname(String handle) {
    this.nickname = handle;
  }
  
  public List<Ref<CoreUser>> getUsers() {
    return users;
  }
    
  public boolean isAnonymous() {
    return anonymous;
  }
  
  public void setAnonymous(boolean anonymous) {
    this.anonymous = anonymous;
  }
  
  public boolean isAdministrator() {
    return administrator;
  }
  
  public void setAdministrator(boolean administrator) {
    this.administrator = administrator;
  }
}
