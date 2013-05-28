package com.verophyle.core.server.domain;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Entity
public class AuthEvent extends CoreEntity {

  @Index
  String nonce;
  
  Date date;
  
  public AuthEvent() {
  }
  
  public AuthEvent(String nonce) {
    this.nonce = nonce;
    this.date = new Date();
  }

  public String getNonce() {
    return nonce;
  }
  
  public void setNonce(String nonce) {
    this.nonce = nonce;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", nonce, date.toString());
  }
  
}
