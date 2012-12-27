package com.verophyle.core.client.place;

import java.util.HashMap;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;

public class CorePlaceHistoryMapper implements PlaceHistoryMapper {
	
	private static CorePlaceHistoryMapper instance = null;
	private static HashMap<String, CorePlace.Tokenizer<? extends Place>> tokenizers = new HashMap<String, CorePlace.Tokenizer<? extends Place>>();
	
	@Inject
	public CorePlaceHistoryMapper() throws Exception {
		if (instance != null)
			throw new Exception("CorePlaceHistoryMapper must be a singleton.");
		instance = this;
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