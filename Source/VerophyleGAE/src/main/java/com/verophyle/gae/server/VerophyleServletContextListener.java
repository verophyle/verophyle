/**
 * Copyright © ${year} Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.gae.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.verophyle.core.server.CoreGuiceModule;
import com.verophyle.flashcards.server.FlashcardsGuiceModule;

/**
 * Servlet listener that creats the server-side Guice injector.
 */
public class VerophyleServletContextListener extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(
        new CoreGuiceModule(),
        new FlashcardsGuiceModule(),
        new VerophyleServletModule()
      );
  }

}
