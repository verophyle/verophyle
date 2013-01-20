package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.verophyle.core.shared.domain.CoreEntity;

public abstract class CoreLocatorImpl<E extends CoreEntity<I>, I> 
	extends Locator<E, I> implements CoreLocator<E, I>  {

	private final Injector injector;
	
	@Inject
	public CoreLocatorImpl(Injector injector) {
		super();		
		this.injector = injector;
	}
	
	@Override
	public E create(Class<? extends E> clazz) {
		return injector.getInstance(clazz);
	}

	@Override
	public I getId(E domainObject) {
		return domainObject.getId();
	}

	@Override
	public Object getVersion(E domainObject) {
		return domainObject.getVersion();
	}

}
