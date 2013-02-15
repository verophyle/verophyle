package com.verophyle.core.client.place;

import java.util.logging.Level;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Inject;
import com.verophyle.core.client.CoreLogger;

public class CorePlaceHistoryMapper implements PlaceHistoryMapper {
	
	public static final String SEPARATOR = "/";
	
	private CorePlaceHistoryRegistry registry;
	private CoreLogger logger;
	
	@Inject
	public CorePlaceHistoryMapper(CorePlaceHistoryRegistry registry, CoreLogger logger) throws Exception {
		this.registry = registry;
		this.logger = logger;
	}

	@Override
	public Place getPlace(String token) {
		String[] tokens = token.split(SEPARATOR, 2);
		
		if (tokens.length > 0) {
			CorePlace.Tokenizer<? extends Place> tokenizer = registry.getTokenizer(tokens[0]);
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
			CorePlace.Tokenizer<? extends Place> tokenizer = registry.getTokenizer(corePlace.getPlaceKey());
			if (tokenizer != null) {
				String stateToken = tokenizer.getCoreToken(place);
				return stateToken.isEmpty() ? corePlace.getPlaceKey() : corePlace.getPlaceKey() + SEPARATOR + stateToken;
			}
		}
		
		return null;
	}
	
}
