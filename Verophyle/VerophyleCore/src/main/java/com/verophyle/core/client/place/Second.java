package com.verophyle.core.client.place;

public class Second extends CorePlace {
	public static final String PLACENAME = "Second";
	
	private String text;

	public Second(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer extends CorePlace.Tokenizer<Second> {
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
	public String getPlaceKey() {
		return PLACENAME;
	}
}
