package com.verophyle.flashcards.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.inject.Inject;
import com.verophyle.flashcards.shared.rf.FlashcardDeckProxy;

public class DeckListItem extends Composite implements ValueAwareEditor<FlashcardDeckProxy> {
	
	interface Binder extends UiBinder<ResizeLayoutPanel, DeckListItem> { }
	private static Binder binder = GWT.create(Binder.class);
	
	@UiField
	Label name;
	
	@Inject
	public DeckListItem() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setDelegate(EditorDelegate<FlashcardDeckProxy> delegate) {
	}

	@Override
	public void flush() {
	}

	@Override
	public void onPropertyChange(String... paths) {
	}

	@Override
	public void setValue(FlashcardDeckProxy value) {
		// the editor framework handles this for us
	}

}
