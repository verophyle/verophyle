package com.verophyle.core.server.domain;

import java.util.Date;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.verophyle.core.shared.AuthAction;

@Entity
public class AuthEvent extends CoreEntity {

  @Index
  String nonce;
  AuthAction action;
  Key<CoreUser> userKey;
  Date date;
  
  public AuthEvent() {
  }
  
  public AuthEvent(String nonce, AuthAction action, CoreUser user) {
    this.nonce = nonce;
    this.action = action;
    this.userKey = Key.create(CoreUser.class, user.getId());
    this.date = new Date();
  }

  public String getNonce() {
    return nonce;
  }
  
  public AuthAction getAction() {
    return action;
  }
  
  public Key<CoreUser> getUserKey() {
    return userKey;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return String.format("%s %s: %s", action, nonce, date.toString());
  }
  
}
