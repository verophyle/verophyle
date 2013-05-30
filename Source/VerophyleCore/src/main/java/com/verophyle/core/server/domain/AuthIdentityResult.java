package com.verophyle.core.server.domain;

import com.verophyle.core.shared.AuthAction;
import com.verophyle.core.shared.AuthResult;

public class AuthIdentityResult extends CoreEntity {

  AuthAction action;
  AuthResult result;
  Identity identity;

  public AuthIdentityResult() {
  }
  
  public AuthIdentityResult(AuthAction action, AuthResult result, Identity identity) {
    this.action = action;
    this.result = result;
    this.identity = identity;
  }
  
  public AuthAction getAction() {
    return action;
  }
  
  public AuthResult getResult() {
    return result;
  }
  
  public Identity getIdentity() {
    return identity;
  }
  
}
