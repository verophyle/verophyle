package com.verophyle.core.client.view;

import java.util.logging.Level;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;

public abstract class CoreViewImpl extends Composite implements CoreView {
	
	private CoreLogger logger;
	private CorePresenter presenter;
	
	protected CoreViewImpl(CoreLogger logger, CoreResources res) {
		this.logger = logger;
		res.css().ensureInjected();
	}

	protected void log(Level level, String text) {
		logger.log(level, text);
	}
	
	public Widget asWidget() {
		return this;
	}

	public CorePresenter getPresenter() {
		return presenter;
	}
	
	public void setPresenter(CorePresenter presenter) {
		this.presenter = presenter;
	}
		
}
