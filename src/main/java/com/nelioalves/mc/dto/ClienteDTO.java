package com.nelioalves.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.services.validation.ClienteUpdate;

/**
 * Classe de DTO que vai retornar apenas as informações de Cliente 
 *  
 * 
 * @author Adriano Rocha
 * @since 28/10/2019
 */
@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = -6039685599854941050L;
	private Integer id;
	
	@NotEmpty(message="Campo  nome não pode ser vazio")
	@Length(min=5,max=120,message="O nome deve ter de 5 a 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Campo e-mail não pode ser vazio")
	@Email(message="E-mail Inválido")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	/**
	 * Construtor com argumentos
	 * @param cliente
	 */
	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}
	
	/**
	 * Retorna o id do cliente
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do cliente
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Retorna o nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o email 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
