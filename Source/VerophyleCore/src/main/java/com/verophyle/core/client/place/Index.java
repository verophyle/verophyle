/**
 * Copyright © 2013 Verophyle.  All rights reserved.
 */
package com.verophyle.core.client.place;

public class Index extends CorePlace {
	public static final String KEY = "Index";
	
	private String text;

	public Index(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static class Tokenizer extends CorePlace.Tokenizer<Index> {
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
	public String getPlaceKey() {
		return KEY;
	}
}
