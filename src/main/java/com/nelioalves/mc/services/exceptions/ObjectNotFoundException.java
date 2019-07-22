package com.nelioalves.mc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2869370252312408286L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
