/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import static com.googlecode.objectify.ObjectifyService.*;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.googlecode.objectify.Key;
import com.verophyle.core.server.domain.CoreEntity;

public abstract class CoreLocator<E extends CoreEntity> extends Locator<E, Long> {

  private final Injector injector;
  private final Class<E> domainType;

  @Inject
  public CoreLocator(Injector injector, Class<E> domainType) {
    super();    
    this.domainType = domainType;
    this.injector = injector;
  }
  
  @Override
  public E create(Class<? extends E> clazz) {
    return injector.getInstance(clazz);
  }

  @Override
  public Long getId(E domainObject) {
    return domainObject.getId();
  }

  @Override
  public Object getVersion(E domainObject) {
    return domainObject.getVersion();
  }

  @Override
  public E find(Class<? extends E> clazz, Long id) {
    if (id != null) {
    Key<? extends E> key = Key.create(clazz, id);    
      return ofy().load().type(clazz).filterKey(key).first().get();
    } else {
      return null;
    }
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Class<E> getDomainType() {
    return domainType;
  }

}
