package com.verophyle.core.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.resources.CoreResources;

public class AppViewImpl extends CoreViewImpl implements AppView {

	private static AppViewImplUiBinder uiBinder = GWT.create(AppViewImplUiBinder.class);
	interface AppViewImplUiBinder extends UiBinder<DockLayoutPanel, AppViewImpl> { }
	
	@UiField DockLayoutPanel topLayoutPanel;
	
	@UiField SimplePanel header;
	@UiField SimplePanel footer;
	@UiField SimplePanel sidebar;
	@UiField SimplePanel content;

	@Inject
	public AppViewImpl(CoreLogger logger, CoreResources res) {
		super(logger, res);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public AcceptsOneWidget getHeader() {
		return header;
	}

	@Override
	public AcceptsOneWidget getSidebar() {
		return sidebar;
	}

	@Override
	public AcceptsOneWidget getContent() {
		return content;
	}

	@Override
	public AcceptsOneWidget getFooter() {
		return footer;
	}

}
