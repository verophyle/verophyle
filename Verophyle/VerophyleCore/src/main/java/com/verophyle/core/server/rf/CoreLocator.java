package com.verophyle.core.server.rf;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.verophyle.core.shared.domain.CoreEntity;

public class CoreLocator<E extends CoreEntity<I>, I> extends Locator<E, I> {

	private final Injector injector;
	private final Class<E> domainType;
	private final Class<I> idType;
	
	@Inject
	public CoreLocator(Injector injector, Class<E> domainType, Class<I> idType) {
		super();		
		this.domainType = domainType;
		this.idType = idType;
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

	@Override
	public E find(Class<? extends E> clazz, I id) {
		// TODO: get the service & find
		return null;
	}

	@Override
	public Class<I> getIdType() {
		return idType;
	}

	@Override
	public Class<E> getDomainType() {
		return domainType;
	}

}
