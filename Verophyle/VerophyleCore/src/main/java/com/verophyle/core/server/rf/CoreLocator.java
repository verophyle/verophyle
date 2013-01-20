package com.verophyle.core.server.rf;

import com.verophyle.core.shared.domain.CoreEntity;

public interface CoreLocator<E extends CoreEntity<I>, I> {
	E create(Class<? extends E> clazz);
	I getId(E domainObject);
	Object getVersion(E domainObject);
}
