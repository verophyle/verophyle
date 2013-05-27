/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.verophyle.core.server.Functional;

/**
 * An Identity is a user account on Verophyle, which may 
 * be associated with zero or more datastore users.
 */
@Entity
public class Identity extends CoreEntity {
  
  public static final String GUEST_NICKNAME = "Anonymous";

  @Index
  String nickname;
  
  @Index
  @Load
  List<Ref<CoreUser>> userRefs = new ArrayList<Ref<CoreUser>>();
  
  boolean anonymous;
  boolean administrator;
  
  public Identity() {
  }
  
  public String getNickname() {
    if (nickname != null && !nickname.isEmpty())
      return nickname;

    for (Ref<CoreUser> user : userRefs) {
      String userNick = user.get().getNickname();
      if (userNick != null && !userNick.isEmpty())
        return userNick;
    }
    
    return "? unknown user ?";
  }
  
  public void setNickname(String handle) {
    this.nickname = handle;
  }
  
  public List<CoreUser> getUsers() {
    return Functional.deref(userRefs);
  }
  
  public void setUsers(List<CoreUser> users) {
    this.userRefs = Functional.toref(users);
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
  
  public void addUser(CoreUser user) {
    @SuppressWarnings("unused")
    String nick = user.getNickname();
    
    long userId = user.getId();
    for (Ref<CoreUser> ref : userRefs) {
      long refId = ref.get().getId();
      if (refId == userId)
        return;
    }
    
    Ref<CoreUser> ref = Ref.create(user);
    userRefs.add(ref);
  }
  
}
