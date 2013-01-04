package com.verophyle.core.client.activity;

import com.google.inject.Provider;
import com.verophyle.core.client.place.CorePlace;

public interface CoreActivityRegistry<A extends CoreActivity, P extends CorePlace> {
	void register(String placeKey, Provider<? extends CoreActivityProxy<? extends A, ? extends P>> provider);
	Provider<? extends CoreActivityProxy<? extends A, ? extends P>> getProvider(String placeKey);
}
