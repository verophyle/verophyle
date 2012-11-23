package com.verophyle.core.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.verophyle.core.client.CoreResources;

public abstract class CoreViewImpl extends Composite implements CoreView {
	
	protected CorePresenter presenter;
	
	protected CoreViewImpl(CoreResources res) {
		res.css().ensureInjected();
	}

	public Widget asWidget() {
		return this;
	}

	public void setPresenter(CorePresenter presenter) {
		this.presenter = presenter;
	}
		
}
