/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.flashcards.client.view.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.verophyle.flashcards.shared.rf.DeckProxy;

public class DeckListItem extends Composite implements ValueAwareEditor<DeckProxy> {
  
  interface Binder extends UiBinder<Label, DeckListItem> { }
  private static Binder binder = GWT.create(Binder.class);
  
  @UiField
  Label name;
  
  @Inject
  public DeckListItem() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setDelegate(EditorDelegate<DeckProxy> delegate) {
  }

  @Override
  public void flush() {
  }

  @Override
  public void onPropertyChange(String... paths) {
  }

  @Override
  public void setValue(DeckProxy value) {
    // the editor framework handles this for us
  }

}
