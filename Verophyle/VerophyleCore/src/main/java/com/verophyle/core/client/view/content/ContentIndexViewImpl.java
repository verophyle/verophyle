package com.verophyle.core.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class ContentIndexViewImpl extends CoreViewImpl implements ContentIndexView {
	
	interface ContentIndexViewUiBinder extends UiBinder<FlowPanel, ContentIndexViewImpl> { }
	private static ContentIndexViewUiBinder uiBinder = GWT.create(ContentIndexViewUiBinder.class);
	
	@UiField Label label;
	@UiField Hyperlink hyperLink;
	
	@Inject
	public ContentIndexViewImpl(CoreLogger logger, CoreResources res) {
		super(logger, res);
		initWidget(uiBinder.createAndBindUi(this));
	}
		
}
