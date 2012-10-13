package com.verophyle.core.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {
	private String text;

	public MainPlace(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		@Override
		public MainPlace getPlace(String token) {
			return new MainPlace(token);
		}

		@Override
		public String getToken(MainPlace place) {
			return place.getText();
		}
		
	}
}
