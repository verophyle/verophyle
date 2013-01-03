package com.verophyle.flashcards.client;

import java.util.logging.Level;

import com.google.gwt.core.client.EntryPoint;
import com.verophyle.core.client.place.CorePlaceHistoryMapper;
import com.verophyle.flashcards.client.place.Flashcards;

public class FlashcardsEntryPoint implements EntryPoint {
	private static boolean loaded = false;

	@Override
	public void onModuleLoad() {
		FlashcardsGinjector.INSTANCE.getLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
		loaded = true;
	}
	
	public static boolean isLoaded() {
		return loaded;
	}
	
	public static void init() {
		FlashcardsGinjector.INSTANCE.getLogger().log(Level.INFO, "FlashcardsEntryPoint.init()");
		
		// register place tokenizer
		CorePlaceHistoryMapper.register(Flashcards.KEY, new Flashcards.Tokenizer());
		
		// instantiate activity mapper to get providers registered
		FlashcardsGinjector.INSTANCE.getContentActivityMapper();
	}
}
