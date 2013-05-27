/**
 * Copyright © 2013 Verophyle Informatics.  All rights reserved.
 */
package com.verophyle.core.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

public class MainServlet extends HttpServlet {

  private static final long serialVersionUID = -2274811349713949068L;

  @Inject
  public MainServlet() {
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    resp.setCharacterEncoding("UTF-8");

    resp.getWriter().append(PAGE);
  }

  private static final String PAGE =
"<!doctype html>\n" +
"<html>\n" +
"  <head>\n" +
"    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n" +
"    <script type=\"text/javascript\" src=\"Verophyle/Verophyle.nocache.js\"></script>\n" +
"    <title>Verophyle</title>\n" +
"  </head>\n" +

"  <body>\n" +
"    <iframe\n" +
"      src=\"javascript:''\" id=\"__gwt_historyFrame\" tabIndex='-1'\n" +
"      style=\"position: absolute; width: 0; height: 0; border: 0\">\n" +
"    </iframe>\n" +

"    <noscript>\n" +
"      <div\n" +
"        style=\"width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif\">\n" +
"        Your web browser must have JavaScript enabled in order for this\n" +
"        application to display correctly.\n" +
"      </div>\n" +
"    </noscript>\n" +

"    <script type=\"text/javascript\">\n" +

"      var _gaq = _gaq || [];\n" +
"      _gaq.push(['_setAccount', 'UA-39359956-1']);\n" +
"      _gaq.push(['_trackPageview']);\n" +

"      (function() {\n" +
"        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;\n" +
"        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';\n" +
"        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);\n" +
"      })();\n" +

"    </script>\n" +
"  </body>\n" +
"</html>\n";

}
