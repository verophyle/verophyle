package com.verophyle.standalone;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class DesktopApplication {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();

		ProtectionDomain domain = DesktopApplication.class.getProtectionDomain();
		URL location = domain.getCodeSource().getLocation();

		WebAppContext context = new WebAppContext();
		context.setServer(server);
		context.setContextPath("/");
		context.setDescriptor(location.toExternalForm() + "/WEB-INF/web.xml");
		context.setWar(location.toExternalForm());

		SocketConnector connector = new SocketConnector();
		connector.setPort(0);

		server.addConnector(connector);
		server.setHandler(context);

		server.start();
		int port = connector.getLocalPort();

		System.out.printf("Server location: %s\n", location);
		System.out.printf("Server port: %d", port);

		server.join();
	}

}
