package com.verophyle.core.client.view;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class DefaultMainView extends Composite implements MainView {
	private Presenter presenter;
	SimplePanel mainPanel = new SimplePanel();
	Element textSpan = DOM.createSpan();
	
	public DefaultMainView() {
		mainPanel.getElement().appendChild(textSpan);
		initWidget(mainPanel);
	}
	
	@Override
	public Widget asWidget() {
		return mainPanel;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public String getText() {
		return textSpan.getInnerText();
	}

	@Override
	public void setText(String text) {
		textSpan.setInnerText(text);
	}
}
