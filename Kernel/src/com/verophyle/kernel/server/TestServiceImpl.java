package com.verophyle.kernel.server;

import com.verophyle.kernel.client.TestService;
import com.verophyle.kernel.shared.TestServiceValidate;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TestServiceImpl extends RemoteServiceServlet implements TestService {

	@Override
	public String getTestInfo(String name) throws IllegalArgumentException {
		name = escapeHtml(name);
		if (!TestServiceValidate.isValidName(name)) {
			throw new IllegalArgumentException("Name must be at least 4 characters long.");
		}
		
		String server_info = getServletContext().getServerInfo();
		String user_agent = getThreadLocalRequest().getHeader("User-Agent");
		
		String result = "Hello, " + name  + ":<br/><br/>"
				+ "Server Info: " + server_info + "<br/><br/>"
				+ "User Agent: " + user_agent;
		
		return result;
	}

	private static final String[] ESCAPES = { 
		"<", "&lt;",
		">", "&gt;",
		"\"", "&quot;",
		"'", "&#39;",
		"&", "&amp;"
	};
	
	private String escapeHtml(String html) {
		if (html == null) return "";
		
		String result = html;
		for (int i = 0; i < ESCAPES.length/2; ++i) {
			result = result.replaceAll(ESCAPES[i*2], ESCAPES[i*2+1]);
		}
		return result;
	}
	
}
