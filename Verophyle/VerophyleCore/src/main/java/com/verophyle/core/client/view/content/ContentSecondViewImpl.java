package com.verophyle.core.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.verophyle.core.client.place.Index;
import com.verophyle.core.client.view.CoreView;

public class ContentSecondViewImpl extends CoreView implements ContentSecondView {
	
	interface ContentSecondViewUiBinder extends UiBinder<FlowPanel, ContentSecondViewImpl> { }
	private static ContentSecondViewUiBinder uiBinder = GWT.create(ContentSecondViewUiBinder.class);
	
	//private Presenter presenter;
	
	@UiField Label label;
	@UiField Hyperlink hyperLink;
	
	public ContentSecondViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		//this.presenter = presenter;
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
