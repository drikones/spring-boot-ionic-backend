package com.nelioalves.mc.dto;

import java.io.Serializable;

/**
 * Classe usada para receber o usuário e a senha 
 * 
 * @author Adriano Rocha
 * @since 22/12/2019
 */
public class CredenciaisDTO implements Serializable {

	private static final long serialVersionUID = -4389080818520729149L;
	private String email;
	private String senha;

	/**
	 * Construtor do DTO das credenciais sem argumentos
	 */
	public CredenciaisDTO() {
	}

	/**
	 * Retorna o email do usuário
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o email do usuario
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retorna a senha do usuário
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Seta a senha do usuário
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
