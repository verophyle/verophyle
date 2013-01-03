package com.verophyle.flashcards.client.view.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;
import com.verophyle.core.client.resources.CoreResources;
import com.verophyle.core.client.view.CoreViewImpl;
import com.verophyle.flashcards.client.FlashcardsLogger;

public class ContentFlashcardsViewImpl extends CoreViewImpl implements ContentFlashcardsView {
	
	interface ContentFlashcardsViewUiBinder extends UiBinder<FlowPanel, ContentFlashcardsViewImpl> {}
	private static ContentFlashcardsViewUiBinder uiBinder = GWT.create(ContentFlashcardsViewUiBinder.class);

	@Inject
	public ContentFlashcardsViewImpl(FlashcardsLogger logger, CoreResources res) {
		super(logger, res);
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}
