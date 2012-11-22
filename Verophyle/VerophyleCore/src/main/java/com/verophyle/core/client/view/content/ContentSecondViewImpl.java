package com.verophyle.core.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreResources;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.CoreViewImpl;

public class ContentSecondViewImpl extends CoreViewImpl implements ContentSecondView {
	
	interface ContentSecondViewUiBinder extends UiBinder<FlowPanel, ContentSecondViewImpl> { }
	private static ContentSecondViewUiBinder uiBinder = GWT.create(ContentSecondViewUiBinder.class);
		
	@UiField Label label;
	@UiField Hyperlink hyperLink;
	
	@Inject
	public ContentSecondViewImpl(CoreResources res) {
		super(res);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public String getText() {
		return label.getText();
	}

	@Override
	public void setText(String text) {
		label.setText(text);
		
		String historyToken = getHistoryToken(new Index(text));
		hyperLink.setText(historyToken);
		hyperLink.setTargetHistoryToken(historyToken);
	}
		
}
