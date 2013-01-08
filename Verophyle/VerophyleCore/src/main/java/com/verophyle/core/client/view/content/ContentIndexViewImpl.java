package com.verophyle.core.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class ContentIndexViewImpl extends CoreViewImpl implements ContentIndexView {
	
	interface Binder extends UiBinder<SimplePanel, ContentIndexViewImpl> { }
	private static Binder binder = GWT.create(Binder.class);
		
	@Inject
	public ContentIndexViewImpl(CoreLogger logger, CoreResources res) {
		super(logger, res);
		initWidget(binder.createAndBindUi(this));
	}
		
}
