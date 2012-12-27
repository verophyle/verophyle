package com.verophyle.core.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public abstract class CorePlace extends Place {
	public abstract String getPlaceKey();	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if (!obj.getClass().getName().equals(this.getClass().getName()))
			return false;
		
		CorePlace corePlace = (CorePlace)obj;
		return corePlace.getPlaceKey().equals(this.getPlaceKey());
	}
	
	@Override
	public int hashCode() {
		String placeKey = getPlaceKey();
		if (placeKey == null) placeKey = "";
		
		return placeKey.hashCode();
	}
	
	public static abstract class Tokenizer<P extends Place> implements PlaceTokenizer<P> {
		@SuppressWarnings("unchecked")
		public String getCoreToken(Place place) {
			return getToken((P)place); 
		}
	}
	
}
