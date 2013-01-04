package com.verophyle.core.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;

public interface CoreEntityProxy<I> extends EntityProxy {
	I getId();
	Integer getVersion();
}
