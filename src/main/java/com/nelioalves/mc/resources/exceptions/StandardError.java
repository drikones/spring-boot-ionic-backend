package com.nelioalves.mc.resources.exceptions;

import java.io.Serializable;

/**
 * Classe auxiliadora que tem o status de erro HTTP, a mensagem de erro e o
 * instante em milissegundos (ms) do erro
 * 
 * @author Adriano Rocha
 * @since 21/07/2019
 */
public class StandardError implements Serializable {

	private static final long serialVersionUID = 8165639581018339402L;
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	/**
	 * Construtor que inicia os argumentos
	 * 
	 * @param timestamp
	 * @param status
	 * @param msg
	 * @param error
	 * @param message
	 * @param path
	 */
	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
