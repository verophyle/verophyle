/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.shared;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Gravatar {

  public static String getHash(String email) {
    if (email != null && !email.isEmpty()) {
      return md5(email.toLowerCase());
    }
    
    return null;
  }
  
  private static String byte2hex(byte[] array) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < array.length; ++i) {
      sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));     
    }
    return sb.toString();
  }
    
  private static String md5(String message) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      return byte2hex(md.digest(message.getBytes("UTF-8")));
    } catch (NoSuchAlgorithmException e) {
    } catch (UnsupportedEncodingException e) {
    }
    
    return null;
  }
}
