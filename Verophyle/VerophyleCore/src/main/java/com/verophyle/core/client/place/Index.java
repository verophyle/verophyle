package com.verophyle.core.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Index extends Place {
	private String text;

	public Index(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Index> {
		@Override
		public Index getPlace(String token) {
			return new Index(token);
		}

		@Override
		public String getToken(Index place) {
			return place.getText();
		}
	}
}
