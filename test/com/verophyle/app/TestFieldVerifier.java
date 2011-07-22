package com.verophyle.app;

import static org.junit.Assert.*;
import org.junit.Test;
import com.verophyle.app.shared.FieldVerifier;

public class TestFieldVerifier {

	@Test
	public void testIsValidName() {
		assertTrue(FieldVerifier.isValidName("four"));
		assertFalse(FieldVerifier.isValidName("ab"));
	}

}
