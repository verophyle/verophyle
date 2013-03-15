/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.flashcards.client.view.content;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;
import com.verophyle.core.client.view.widgets.TextBoxWithIntroText;
import com.verophyle.flashcards.client.FlashcardsLogger;
import com.verophyle.flashcards.client.resources.FlashcardsResources;
import com.verophyle.flashcards.client.view.widgets.DeckListItem;
import com.verophyle.flashcards.shared.rf.DeckProxy;
import com.verophyle.flashcards.shared.rf.FlashcardsRequestFactory;

public class ContentFlashcardsViewImpl extends CoreViewImpl implements ContentFlashcardsView {
  
  interface Binder extends UiBinder<FlowPanel, ContentFlashcardsViewImpl> {}
  interface Driver extends RequestFactoryEditorDriver<List<DeckProxy>, ListEditor<DeckProxy, DeckListItem>> { }
  
  private final Binder binder = GWT.create(Binder.class);
  private final Driver driver = GWT.create(Driver.class);
  
  @UiField
  TextBoxWithIntroText searchBox;
  
  @UiField
  FlowPanel deckListContainer;
  
  private final EventBus eventBus;
  private final FlashcardsRequestFactory requestFactory;
  
  private final List<DeckProxy> deckList;
  
  @Inject
  public ContentFlashcardsViewImpl(
      EventBus eventBus, 
      FlashcardsRequestFactory requestFactory, 
      FlashcardsLogger logger,
      CoreResources res,
      FlashcardsResources fres) {
    super(logger, res);
    
    this.eventBus = eventBus;
    this.requestFactory = requestFactory;
    
    fres.css().ensureInjected();    
    initWidget(binder.createAndBindUi(this));
    
    ListEditor<DeckProxy, DeckListItem> editor = ListEditor.of(new ListItemSource());
    driver.initialize(this.eventBus, this.requestFactory, editor);
    driver.display(new ArrayList<DeckProxy>());
    
    deckList = editor.getList();
  }
  
  @Override
  protected void onLoad() {
    requestFactory.flashcardDeckRequest().createDeck("User-Maat-Re").fire(new Receiver<DeckProxy>() {
      @Override
      public void onSuccess(DeckProxy response) {
        deckList.add(response);
      }
    });
  }
  
  
  private class ListItemSource extends EditorSource<DeckListItem> {
    private LinkedList<DeckListItem> unused = new LinkedList<DeckListItem>();
    
    @Override
    public DeckListItem create(int index) {
      DeckListItem deck = unused.size() > 0 ? unused.removeFirst() : new DeckListItem();
      deckListContainer.insert(deck, index);
      return deck;
    }
    
    @Override
    public void dispose(DeckListItem deck) {
      if (deck != null) {
        deckListContainer.remove(deck);
        unused.addLast(deck);
      }
    }
    
    @Override
    public void setIndex(DeckListItem deck, int index) {
      deckListContainer.insert(deck, index);
    }
  }
  
}
