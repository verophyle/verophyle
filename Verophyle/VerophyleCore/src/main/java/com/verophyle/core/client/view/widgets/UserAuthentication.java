package com.verophyle.core.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class UserAuthentication extends Composite {

	interface Binder extends UiBinder<FlowPanel, UserAuthentication> {}
	private static Binder binder = GWT.create(Binder.class);

	@UiField
	Label userInfo;
	
	@UiField
	Button userLogin;
	
	@Inject
	public UserAuthentication() {
		initWidget(binder.createAndBindUi(this));
	}
	
	public Label getUserInfo() {
		return userInfo;
	}
	
	public Button getUserLogin() {
		return userLogin;
	}
	
}
