/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.gae.client;

import java.util.logging.Level;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.verophyle.core.client.CoreEntryPoint;
import com.verophyle.flashcards.client.FlashcardsEntryPoint;

/**
 * Entry point for the verophyle GAE module.
 * 
 * When loaded, it waits for all the other modules to be loaded
 * and then calls their <code>init()</code> functions.  Finally,
 * it calls <code>CoreEntryPoint.start()</code>.
 */
public class VerophyleEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    VerophyleGinjector.INSTANCE.getVerophyleLogger().log(Level.INFO, this.getClass().getName() + ".onModuleLoad()");
    
    Scheduler.get().scheduleFinally(new Scheduler.RepeatingCommand() {

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
