package com.verophyle.core.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class Second extends CorePlace {
	public static final String PLACENAME = "Second";
	
	private String text;

	public Second(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Second> {
		@Override
		public Second getPlace(String token) {
			return new Second(token);
		}

		@Override
		public String getToken(Second place) {
			return place.getText();
		}
	}

	@Override
	public String getPlaceName() {
		return PLACENAME;
	}
}
