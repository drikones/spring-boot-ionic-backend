package com.nelioalves.mc.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 2869370252312408286L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
