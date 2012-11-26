package com.verophyle.core.client.view.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class FooterViewImpl extends CoreViewImpl implements FooterView {

	interface FooterViewImplUiBinder extends UiBinder<HTML, FooterViewImpl> { }
	private static FooterViewImplUiBinder uiBinder = GWT.create(FooterViewImplUiBinder.class);

	@Inject
	public FooterViewImpl(CoreResources res) {
		super(res);
		initWidget(uiBinder.createAndBindUi(this));
	}

}
