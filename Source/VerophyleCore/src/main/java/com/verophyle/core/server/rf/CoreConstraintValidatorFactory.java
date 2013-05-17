/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server.rf;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class CoreConstraintValidatorFactory implements ConstraintValidatorFactory {

  private final Injector injector;

  @Inject
  public CoreConstraintValidatorFactory(Injector injector) {
    this.injector = injector;
  }

  @Override
  public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

  //@Override
  //public void releaseInstance(ConstraintValidator<?, ?> instance) {
  //  // do nothing
  //}

}
