package com.verophyle.core.server;

import com.google.web.bindery.requestfactory.shared.Locator;
import com.verophyle.core.shared.CoreEntity;
import com.verophyle.core.shared.NotImplementedException;

public class CoreLocator<E extends CoreEntity<I>, I> extends Locator<E, I> {

	@Override
	public E create(Class<? extends E> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
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
