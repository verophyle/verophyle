package com.verophyle.gae.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.verophyle.core.client.CoreEntryPoint;
import com.verophyle.flashcards.client.FlashcardsEntryPoint;

public class VerophyleEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Scheduler.get().scheduleEntry(new Scheduler.RepeatingCommand() {

			@Override
			public boolean execute() {
				if (CoreEntryPoint.isLoaded() && FlashcardsEntryPoint.isLoaded()) {
					CoreEntryPoint.init();
					FlashcardsEntryPoint.init();
					
					CoreEntryPoint.start();					
					return false;
				}
				
				return true;
			}
			
		});
	}

}
