/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class CoreServiceLayerDecorator extends ServiceLayerDecorator {
  
  private final Injector injector;
  private final Validator validator;
  
  @Inject
  protected CoreServiceLayerDecorator(final Injector injector, final Validator validator) {
    super();
    
    this.injector = injector;
    this.validator = validator;
  }

  @Override
  public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

  @Override
  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

  @Override
  public <T> Set<ConstraintViolation<T>> validate(T domainObject) {
    return validator.validate(domainObject);
  }

}
