package com.verophyle.core.server;

import java.util.logging.Logger;

public class PlaceHolder {
	
	private static final Logger log = Logger.getLogger("test");

	static {
		log.info("info");
		log.warning("warning");
		log.severe("error");
	}
	
}
