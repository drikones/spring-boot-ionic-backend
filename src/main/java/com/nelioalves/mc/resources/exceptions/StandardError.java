package com.nelioalves.mc.resources.exceptions;

import java.io.Serializable;

/**
 * Classe auxiliadora que tem o status de erro HTTP, a mensagem de erro e o instante em 
 * milissegundos (ms) do erro
 * 
 * @author Adriano Rocha
 * @since 21/07/2019
 */
public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 8165639581018339402L;
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	/**
	 * Construtor que inicia os argumentos
	 * 
	 * @param status
	 * @param msg
	 * @param timeStamp
	 */
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	/**
	 * Retorna o status http do erro
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Seta o status http
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Retorna a mensagem
	 * @return msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Seta a mensagem
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * Retorna o instante do erro
	 * 
	 * @return timeStamp
	 */
	public Long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Seta o instante do erro
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
