package com.verophyle.core.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class AppViewImpl extends CoreView implements AppView {

	private static AppViewImplUiBinder uiBinder = GWT.create(AppViewImplUiBinder.class);
	interface AppViewImplUiBinder extends UiBinder<SplitLayoutPanel, AppViewImpl> { }
	
	//private Presenter presenter;
	
	@UiField SplitLayoutPanel topLayoutPanel;
	
	@UiField SimplePanel header;
	@UiField SimplePanel footer;
	@UiField SimplePanel sidebar;
	@UiField SimplePanel content;

	@Inject
	public AppViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public Widget asWidget() {
		return this;
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

	@Override
	public void setPresenter(Presenter presenter) {
		//this.presenter = presenter;
	}

}
