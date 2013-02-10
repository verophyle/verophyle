package com.verophyle.core.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;

public class IdentityAuthentication extends Composite {

	interface Binder extends UiBinder<FlowPanel, IdentityAuthentication> {}
	private static Binder binder = GWT.create(Binder.class);

	private String url;
	
	@UiField
	Label identityInfo;
	
	@UiField
	Button identityLogin;
	
	@UiField
	Image gravatarImage;
	
	@Inject
	public IdentityAuthentication() {
		initWidget(binder.createAndBindUi(this));
		identityLogin.removeStyleName("gwt-Button");
		
		identityLogin.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onLoginClick();
			}			
		});
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Label getIdentityInfo() {
		return identityInfo;
	}
	
	public Button getIdentityLogin() {
		return identityLogin;
	}
	
	public Image getGravatarImage() {
		return gravatarImage;
	}
	
	private void onLoginClick() {
		if (url != null && !url.isEmpty()) {
			Window.Location.replace(url);
		}
	}
		
}
