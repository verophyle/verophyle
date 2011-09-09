package com.verophyle.standalone.server;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class VerophyleDesktopApplication {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();
		
		WebAppContext context = new WebAppContext();
		context.setServer(server);
		context.setContextPath("/");

		ProtectionDomain domain = VerophyleDesktopApplication.class.getProtectionDomain();
		URL location = domain.getCodeSource().getLocation();		
		context.setWar(location.toExternalForm());		
		
		SocketConnector connector = new SocketConnector();
		connector.setPort(0);
		
		server.addConnector(connector);
		server.setHandler(context);
		
		server.start();
		int port = connector.getLocalPort();		
		server.join();
	}

}
