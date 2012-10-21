package com.verophyle.core.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class Main extends Place {
	private String text;

	public Main(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer implements PlaceTokenizer<Main> {
		@Override
		public Main getPlace(String token) {
			return new Main(token);
		}

		@Override
		public String getToken(Main place) {
			return place.getText();
		}
	}
}
