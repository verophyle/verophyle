package com.verophyle.standalone.server;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class VerophyleDesktopApplication {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		File cur = new File(".");
		System.out.println("Current dir: " + cur.getCanonicalPath());
		
		Server server = new Server(8080);
		WebAppContext handler = new WebAppContext();
		handler.setResourceBase(".");
		handler.setDescriptor("./WEB-INF/web.xml");
		handler.setContextPath("/");
		
		server.setHandler(handler);
		server.setThreadPool(new QueuedThreadPool(20));
		
		server.start();
		server.join();
	}

}
