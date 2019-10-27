package com.nelioalves.mc.resources.exceptions;

import java.io.Serializable;

/**
 * Classe utilitária que retorna o nome do campo e a mensagem de erro do campo a ser tratada na exceção
 * 
 * @author Adriano Rocha
 * @since 26/10/2019
 *
 */
public class FieldMessage implements Serializable {

	private static final long serialVersionUID = -5994765633096351564L;
	private String fieldName;
	private String message;
	
	
	public FieldMessage() {}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	/**
	 * Retorna o nome do campo
	 * @return fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 *  Seta o nome do campo
	 * @param fieldName
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	/**
	 * Retorna a mensagem de erro associada ao campo
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Seta  a mensagem de erro associada ao campo
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	

}
