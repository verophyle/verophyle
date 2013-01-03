package com.verophyle.core.client.place;

import java.util.HashMap;
import java.util.logging.Level;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;

public class CorePlaceHistoryMapper implements PlaceHistoryMapper {
	
	private static CorePlaceHistoryMapper instance = null;
	private static final HashMap<String, CorePlace.Tokenizer<? extends Place>> tokenizers = 
		new HashMap<String, CorePlace.Tokenizer<? extends Place>>();
	
	private CoreLogger logger;
	
	@Inject
	public CorePlaceHistoryMapper(CoreLogger logger) throws Exception {
		if (instance != null)
			throw new Exception("CorePlaceHistoryMapper must be a singleton.");
		instance = this;
		this.logger = logger;
	}

	public static CorePlaceHistoryMapper get() {
		return instance;
	}
	
	public static void register(String key, CorePlace.Tokenizer<? extends Place> tokenizer) {
		tokenizers.put(key, tokenizer);
	}
	
	@Override
	public Place getPlace(String token) {
		String[] tokens = token.split(":", 2);
		
		if (tokens.length > 0) {
			CorePlace.Tokenizer<? extends Place> tokenizer = tokenizers.get(tokens[0]);
			if (tokenizer != null)
				return tokenizer.getPlace(tokens.length > 1 ? tokens[1] : null);
		}
		
		logger.log(Level.SEVERE, "unable to get place for " + token);
		
		return null;
	}
	
	@Override
	public String getToken(Place place) {
		CorePlace corePlace = place instanceof CorePlace ? (CorePlace)place : null;
		if (corePlace != null) {
			CorePlace.Tokenizer<? extends Place> tokenizer = tokenizers.get(corePlace.getPlaceKey());
			if (tokenizer != null)
				return tokenizer.getCoreToken(place);
		}
		
		return null;
	}
	
}