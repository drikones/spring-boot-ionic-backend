package com.nelioalves.mc.services.exceptions;

public class FileException extends RuntimeException {

	private static final long serialVersionUID = -959635816915937214L;
	
	public FileException(String mensagem) {
		super(mensagem);
	}
	
	public FileException(String mensagem, Throwable throwable) {
		super(mensagem, throwable);
	}

}
