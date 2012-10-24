package com.verophyle.core.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.verophyle.core.client.place.Second;
import com.verophyle.core.client.view.CoreView;

public class ContentIndexView extends CoreView implements ContentView {
	
	private static ContentIndexViewUiBinder uiBinder = GWT.create(ContentIndexViewUiBinder.class);
	interface ContentIndexViewUiBinder extends UiBinder<FlowPanel, ContentIndexView> { }
	
	//private Presenter presenter;

	@UiField Label label;
	@UiField Hyperlink hyperLink;
	
	@Inject
	public ContentIndexView() {
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
		
		String historyToken = getHistoryToken(new Second(text));
		hyperLink.setText(historyToken);
		hyperLink.setTargetHistoryToken(historyToken);
	}
	
}
