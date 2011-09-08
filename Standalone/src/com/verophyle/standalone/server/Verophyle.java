package com.verophyle.standalone.server;

import java.awt.Desktop;
import java.io.File;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Verophyle {

	public static void main(String[] args) throws Exception, InterruptedException {
		File cur = new File(".");
		System.out.println("Current dir: " + cur.getCanonicalPath());
		
		Server server = new Server(8080);
		WebAppContext handler = new WebAppContext();
		
		handler.setResourceBase("./war");
		handler.setDescriptor("./war/WEB-INF/web.xml");
		handler.setContextPath("/");
		
		server.setHandler(handler);
		server.setThreadPool(new QueuedThreadPool(20));
		
		server.start();
		
		//Desktop.getDesktop().browse(uri);
		
		server.join();
	}
	
}
