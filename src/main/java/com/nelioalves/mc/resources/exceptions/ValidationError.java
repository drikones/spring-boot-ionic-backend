package com.nelioalves.mc.resources.exceptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Retorna o formato do erro a ser apresentado quando for lançada a exceção de MethodArgumentNotValidException
 * 
 * @author Adriano Rocha
 * @since 26/10/2019
 */
public class ValidationError extends StandardError implements Serializable {

	private static final long serialVersionUID = -7464201118611359767L;
	private List<FieldMessage> errors = new ArrayList<>();
	
	/**
	 * Construtor obrigatório, chamando o contrutor da superclasse
	 * 
	 * @param status
	 * @param msg
	 * @param timeStamp
	 */
	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	/**
	 *  retorna a lista de mensagens
	 * @return errors
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}

	/**
	 * Seta a lista de mensagens
	 * @param errors
	 */
	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

	

}
