package com.verophyle.core.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface CoreResources extends ClientBundle {
	public static final CoreResources INSTANCE = GWT.create(CoreResources.class);
	
	@Source("taj-mahal.jpg")
	ImageResource tajMahal();
}
