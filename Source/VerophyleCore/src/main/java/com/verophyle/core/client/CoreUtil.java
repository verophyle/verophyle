/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.client;

import com.google.inject.Inject;
import com.verophyle.core.shared.rf.CoreRequestFactory;

public class CoreUtil {

  private final CoreRequestFactory requestFactory;

  @Inject
  public CoreUtil(CoreRequestFactory requestFactory) {
    this.requestFactory = requestFactory;
  }

  public static String genUuid() {
    return generateUuidString();
  }

  private static native String generateUuidString() /*-{
    var chars = '0123456789ABCDEF'.split('');
    var radix = chars.length;
    var uuid = [];
    var r;

    uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
    uuid[14] = '4';

    for (var i = 0; i < 36; ++i) {
      if (!uuid[i]) {
        r = 0 | Math.random() * 16;
        uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
      }
    }

    return uuid.join('');
  }-*/;

}
