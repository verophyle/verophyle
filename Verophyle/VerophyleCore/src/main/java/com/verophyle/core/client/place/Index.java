package com.verophyle.core.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Index extends CorePlace {
	public static final String PLACENAME = "Index";
	
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

	@Override
	public String getPlaceName() {
		return PLACENAME;
	}
}
