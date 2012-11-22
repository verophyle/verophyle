package com.verophyle.core.client.view.sidebar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTML;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class SidebarViewImpl extends CoreViewImpl implements SidebarView {

	interface SidebarViewImplUiBinder extends UiBinder<HTML, SidebarViewImpl> {	}
	private static SidebarViewImplUiBinder uiBinder = GWT.create(SidebarViewImplUiBinder.class);

	@Inject
	public SidebarViewImpl(CoreResources res) {
		super(res);
		initWidget(uiBinder.createAndBindUi(this));
	}

}
