package com.verophyle.core.client.view.widgets;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

public class TextBoxWithIntroText extends TextBox {
	
	private boolean initialText = true;
	
	@Inject
	public TextBoxWithIntroText() {
		super();
		
		addKeyPressHandler(handler);
	}
	
	private static final KeyPressHandler handler = new KeyPressHandler() {
		@Override
		public void onKeyPress(KeyPressEvent event) {
			TextBoxWithIntroText tb = (TextBoxWithIntroText) event.getSource();
			if (tb.initialText){
				tb.setText("");
				tb.initialText = false;
			}
		}		
	};
	
}
