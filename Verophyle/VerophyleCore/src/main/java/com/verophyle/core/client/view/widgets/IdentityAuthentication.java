package com.verophyle.core.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class IdentityAuthentication extends Composite {

	interface Binder extends UiBinder<FlowPanel, IdentityAuthentication> {}
	private static Binder binder = GWT.create(Binder.class);

	@UiField
	Label identityInfo;
	
	@UiField
	Button identityLogin;
	
	@Inject
	public IdentityAuthentication() {
		initWidget(binder.createAndBindUi(this));
	}
	
	public Label getIdentityInfo() {
		return identityInfo;
	}
	
	public Button getIdentityLogin() {
		return identityLogin;
	}
	
}
