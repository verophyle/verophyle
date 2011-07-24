package com.verophyle.kernel.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>TestService</code>.
 */
public interface TestServiceAsync {
	void getTestInfo(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
