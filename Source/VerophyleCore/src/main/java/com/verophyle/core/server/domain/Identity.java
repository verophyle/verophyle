/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.OnSave;
import com.verophyle.core.server.Functional;

/**
 * An Identity is a user account on Verophyle, which may be associated
 * with zero or more datastore users.
 */
@Entity
public class Identity extends CoreEntity {
  
  public static final String GUEST_NICKNAME = "Anonymous";

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

  @Index
  String nickname;
  
  @Index
  @Load
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
  
  public List<CoreUser> getUserList() {
    return Collections.unmodifiableList(Functional.deref(users));
  }

  public void addUser(CoreUser user) {
    @SuppressWarnings("unused")
    String nick = user.getNickname();
    
    for (Ref<CoreUser> ref : users) {
      long refId = ref.getKey().getId();
      long userId = user.getId();
      
      if (refId == userId)
        return;
    }
    
    Key<CoreUser> key = Key.create(CoreUser.class, user.getId());
    Ref<CoreUser> ref = Ref.create(key);
    users.add(ref);
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
