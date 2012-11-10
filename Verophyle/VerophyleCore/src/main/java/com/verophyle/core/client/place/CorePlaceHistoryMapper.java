package com.verophyle.core.client.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
	Index.Tokenizer.class,
	Second.Tokenizer.class
})
public interface CorePlaceHistoryMapper extends PlaceHistoryMapper {
}
