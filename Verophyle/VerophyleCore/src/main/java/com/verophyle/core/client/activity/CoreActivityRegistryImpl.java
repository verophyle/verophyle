package com.verophyle.core.client.activity;

import java.util.HashMap;
import java.util.logging.Level;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.verophyle.core.client.CoreLogger;
import com.verophyle.core.client.place.CorePlace;

public class CoreActivityRegistryImpl implements CoreActivityRegistry {
	
	private final HashMap<String, Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>>> providers = 
			new HashMap<String, Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>>>();
	
	private CoreLogger logger;
	
	@Inject
	public CoreActivityRegistryImpl(CoreLogger logger) throws Exception {
		this.logger = logger;
	}
		
	public void register(String placeKey, Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> provider) {
		logger.log(Level.INFO, "ContentActivityRegistry.register(\"" + placeKey + "\", ...)");
		providers.put(placeKey, provider);
	}
	
	public Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> getProvider(String placeKey) {
		return providers.get(placeKey);
	}
	
}
