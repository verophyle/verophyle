package com.verophyle.core.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;

public interface CoreEntityProxy extends EntityProxy {
	Long getId();
	Integer getVersion();
}
