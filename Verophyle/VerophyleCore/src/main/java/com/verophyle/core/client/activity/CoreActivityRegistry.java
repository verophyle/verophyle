package com.verophyle.core.client.activity;

import com.google.inject.Provider;
import com.verophyle.core.client.place.CorePlace;

public interface CoreActivityRegistry {
	void register(String placeKey, Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> provider);
	Provider<? extends CoreActivityProxy<? extends CoreActivity, ? extends CorePlace>> getProvider(String placeKey);
}
