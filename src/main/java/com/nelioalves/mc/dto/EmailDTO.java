package com.nelioalves.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


/**
 * Classe de DTO usada na ação de reset de senha do usuário
 * 
 * @author Adriano Rocha
 * @since 05/01/2020
 *
 */
public class EmailDTO implements Serializable {
	
	private static final long serialVersionUID = 8450016507233292232L;
	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="Email inválido")
	private String email;

	public EmailDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}