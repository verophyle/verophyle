package com.verophyle.core.client.view.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.verophyle.core.client.view.CoreView;

public class HeaderViewImpl extends CoreView implements HeaderView {
	
	interface HeaderViewUiBinder extends UiBinder<HTMLPanel, HeaderViewImpl> { }
	private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

	@Inject
	public HeaderViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
	}

}
