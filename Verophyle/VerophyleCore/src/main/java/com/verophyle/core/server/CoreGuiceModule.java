package com.verophyle.core.server;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.verophyle.core.server.rf.CoreConstraintValidatorFactory;
import com.verophyle.core.server.rf.CoreExceptionHandler;
import com.verophyle.core.server.rf.CoreServiceLayerDecorator;
import com.verophyle.core.server.rf.CoreServiceLocator;
import com.verophyle.core.server.rf.CoreServiceLocatorImpl;

public class CoreGuiceModule extends AbstractModule {

	@Override
	protected void configure() {
		// RequestFactory
		bind(ExceptionHandler.class).to(CoreExceptionHandler.class);
		bind(ServiceLayerDecorator.class).to(CoreServiceLayerDecorator.class);
		bind(CoreServiceLocator.class).to(CoreServiceLocatorImpl.class);
	}

	@Provides
	@Singleton
	public Logger getLogger() {
		return LoggerFactory.getLogger("VerophyleCore");
	}
	
	// RequestFactory
	@Provides
	@Singleton
	public ValidatorFactory getValidatorFactory(Injector injector) {
		return Validation
				.byDefaultProvider()
				.configure()
				.constraintValidatorFactory(new CoreConstraintValidatorFactory(injector))
				.buildValidatorFactory();
	}

	@Provides
	@Singleton
	public Validator getValidator(ValidatorFactory validatorFactory) {
		return validatorFactory.getValidator();
	}
	
}
