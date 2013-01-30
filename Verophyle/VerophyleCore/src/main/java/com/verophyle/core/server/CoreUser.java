package com.verophyle.core.server;

public interface CoreUser {
	int compareTo(CoreUser user);
	boolean equals(Object object);
	String getAuthDomain();
	String getEmail();
	String getFederatedIdentity();
	String getNickname();
	String getUserId();
	int hashCode();
	String toString();
}
