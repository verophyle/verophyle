package com.verophyle.core.client.view.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class HeaderViewImpl extends CoreViewImpl implements HeaderView {
	
	interface HeaderViewUiBinder extends UiBinder<HTML, HeaderViewImpl> { }
	private static HeaderViewUiBinder uiBinder = GWT.create(HeaderViewUiBinder.class);

	@Inject
	public HeaderViewImpl(CoreResources res) {
		super(res);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}