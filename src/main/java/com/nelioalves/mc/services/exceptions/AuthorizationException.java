package com.nelioalves.mc.services.exceptions;

public class AuthorizationException extends RuntimeException {


	private static final long serialVersionUID = -5542638663776588824L;

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
