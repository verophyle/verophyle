package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.verophyle.core.shared.NotImplementedException;
import com.verophyle.core.shared.domain.CoreEntity;

public class CoreLocator<E extends CoreEntity<I>, I> extends Locator<E, I> {

	private final Injector injector;
	
	@Inject
	public CoreLocator(Injector injector) {
		super();
		
		this.injector = injector;
	}
	
	@Override
	public E create(Class<? extends E> clazz) {
		return injector.getInstance(clazz);
	}

	@Override
	public E find(Class<? extends E> clazz, I id) {
		throw new NotImplementedException();
	}

	@Override
	public Class<E> getDomainType() {
		throw new UnsupportedOperationException();
	}

	@Override
	public I getId(E domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<I> getIdType() {
		throw new NotImplementedException();
	}

	@Override
	public Object getVersion(E domainObject) {
		return domainObject.getVersion();
	}

}
