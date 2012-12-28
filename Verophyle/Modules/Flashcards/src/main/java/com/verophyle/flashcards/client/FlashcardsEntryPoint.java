package com.verophyle.flashcards.client;

import java.util.logging.Level;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class FlashcardsEntryPoint implements EntryPoint {
	
	private static final FlashcardsGinjector injector = GWT.create(FlashcardsGinjector.class);
	
	private static boolean loaded = false;

	@Override
	public void onModuleLoad() {
		injector.getLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
		loaded = true;
	}
	
	public static boolean isLoaded() {
		return loaded;
	}
	
	public static void init() {
		injector.getLogger().log(Level.INFO, "FlashcardsEntryPoint.init()");
	}

}
