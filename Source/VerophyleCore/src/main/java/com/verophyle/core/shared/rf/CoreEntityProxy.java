/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.shared.rf;

import com.google.web.bindery.requestfactory.shared.EntityProxy;

public interface CoreEntityProxy extends EntityProxy {
  Long getId();
  Integer getVersion();
}
