package com.verophyle.core.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

/**
 * This is a servlet that does nothing but allow for GAE redirection.
 */
public class AuthenticationServlet extends HttpServlet {

  private static final long serialVersionUID = 3264417093054003396L;

  @Inject
  public AuthenticationServlet() {
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    final PrintWriter writer = resp.getWriter();
    writer.append("<!DOCTYPE HTML><html><head></head><body></body></html>");
  }
}
