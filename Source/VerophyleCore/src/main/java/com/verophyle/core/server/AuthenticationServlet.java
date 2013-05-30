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
import com.verophyle.core.server.domain.CoreUser;
import com.verophyle.core.shared.AuthAction;

/**
 * This is a servlet that does nothing but allow for GAE redirection.
 */
public class AuthenticationServlet extends HttpServlet {

  private static final long serialVersionUID = 3264417093054003396L;

  private final Logger logger;
  private final CoreUserService userService;
  private final CoreObjectifyService objectifyService;

  @Inject
  public AuthenticationServlet(Logger logger, CoreUserService userService, CoreObjectifyService objectifyService) {
    this.logger = logger;
    this.userService = userService;
    this.objectifyService = objectifyService;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      String action = req.getParameter("action");
      String nonce = req.getParameter("nonce");
      CoreUser user = userService.getCurrentUser();
    
      if (action != null && !action.isEmpty() &&
          nonce != null && !nonce.isEmpty()) {
        AuthAction authAction = AuthAction.valueOf(action);         
        AuthEvent authEvent = new AuthEvent(nonce, authAction, user);
        objectifyService.ofy().save().entity(authEvent).now();
        logger.info("saved auth event {}", authEvent.toString());
      }
      
      resp.setContentType("text/html");
      resp.setCharacterEncoding("UTF-8");

      final PrintWriter writer = resp.getWriter();
      writer.append("<!DOCTYPE HTML><html><head></head><body><p>");
      if (user != null)
        writer.append(user.getNickname());
      writer.append("...</p></body></html>");
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    }
  }
}
