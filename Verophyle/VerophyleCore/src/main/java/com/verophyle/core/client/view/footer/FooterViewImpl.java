package com.verophyle.core.client.view.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;

public class FooterViewImpl extends CoreViewImpl implements FooterView {

	interface Binder extends UiBinder<FlowPanel, FooterViewImpl> { }
	private static Binder binder = GWT.create(Binder.class);

	@Inject
	public FooterViewImpl(CoreLogger logger, CoreResources res) {
		super(logger, res);
		initWidget(binder.createAndBindUi(this));
	}

}
