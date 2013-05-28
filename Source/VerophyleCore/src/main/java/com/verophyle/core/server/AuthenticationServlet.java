/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.google.inject.Inject;
import com.verophyle.core.server.domain.AuthEvent;

/**
 * This is a servlet that does nothing but allow for GAE redirection.
 */
public class AuthenticationServlet extends HttpServlet {

  private static final long serialVersionUID = 3264417093054003396L;

  private final Logger logger;
  private final CoreObjectifyService objectifyService;

  @Inject
  public AuthenticationServlet(Logger logger, CoreObjectifyService objectifyService) {
    this.logger = logger;
    this.objectifyService = objectifyService;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nonce = req.getParameter("nonce");
    if (nonce != null && !nonce.isEmpty()) {
      AuthEvent authEvent = new AuthEvent(nonce);
      objectifyService.ofy().save().entity(authEvent).now();
      logger.info("saved auth event {}", authEvent.toString());
    }
    
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    final PrintWriter writer = resp.getWriter();
    writer.append("<!DOCTYPE HTML><html><head></head><body></body></html>");
  }
}
