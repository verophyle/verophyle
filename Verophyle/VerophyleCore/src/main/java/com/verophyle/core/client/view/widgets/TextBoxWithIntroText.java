package com.verophyle.core.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

public class TextBoxWithIntroText extends TextBox {
	
	private boolean initialText = true;
	
	@Inject
	public TextBoxWithIntroText() {
		super();
		
		this.addStyleName("coreTextBox");
		this.addStyleName("initial");

		addClickHandler(clickHandler);
		addKeyPressHandler(keyPressHandler);
	}
	
	private void Reset() {
		if (initialText) {
			setText("");
			this.removeStyleName("initial");
			initialText = false;
		}
	}
	
	private static final ClickHandler clickHandler = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			TextBoxWithIntroText tb = (TextBoxWithIntroText) event.getSource();
			tb.Reset();
		}
	};
	
	private static final KeyPressHandler keyPressHandler = new KeyPressHandler() {
		@Override
		public void onKeyPress(KeyPressEvent event) {
			TextBoxWithIntroText tb = (TextBoxWithIntroText) event.getSource();
			tb.Reset();
		}		
	};
	
}
