package com.nelioalves.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.mc.services.validation.ClienteInsert;

/**
 * Classe de DTO que vai comportar as informações de cliente,
 * telefone e endereço. Como esse DTO vai ser usado somente para a operação
 * de insert, não será necessário inserir um atributo id nessa classe.
 * 
 * @author Adriano Rocha
 * @since 03/10/2019
 *
 */

@ClienteInsert
public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 5362524947520556218L;
	
	@NotEmpty(message="Campo  nome não pode ser vazio")
	@Length(min=5,max=120,message="O nome deve ter de 5 a 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Campo e-mail não pode ser vazio")
	@Email(message="E-mail Inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfOuCnpj;
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;
	private String complemento;
	private String bairro;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;
	private Integer cidadeId;
	
	/**
	 * Construtor de ClienteNewDTO sem argumentos
	 */
	public ClienteNewDTO() {}
	
	
	
	/**
	 * Retorna o nome do cliente
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome do cliente
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o e-mail do cliente
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o e-mail do cliente 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Retorna o cpf ou o cnpj do cliente
	 * @return cpfOuCnpj
	 */
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	
	/**
	 * Seta o cpf ou o cnpj do cliente
	 * @param cpfOuCnpj
	 */
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	/**
	 * Retorna o tipo do cliente
	 * @return tipo
	 */
	public Integer getTipo() {
		return tipo;
	}
	
	/**
	 * Seta o tipo do cliente
	 * @param tipo
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	/**
	 * Retorna o logradouro do cliente
	 * @return logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Seta o logradouro do cliente
	 * @param logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * Retorna o número do endereço do cliente
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Seta o número do endereço do cliente
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o complemento do cliente
	 * @return complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	
	/**
	 * Seta o complemento do cliente
	 * @param complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Retorna o bairro do cliente
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Seta o bairro do cliente
	 * @param bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Retorna o CEP do cliente
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Seta o CEP do cliente
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Retorna o telefone obrigatório do cliente
	 * @return telefone1
	 */
	public String getTelefone1() {
		return telefone1;
	}

	/**
	 * Seta o telefone obrigatório do cliente
	 * @param telefone1
	 */
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	/**
	 * Retorna o segundo telefone opcional do cliente
	 * @return telefone2
	 */
	public String getTelefone2() {
		return telefone2;
	}

	/**
	 * Seta o segundo telefone opcional do cliente 
	 * @param telefone2
	 */
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	/**
	 * Retorna o terceiro telefone opcional do cliente
	 * @return telefone3
	 */
	public String getTelefone3() {
		return telefone3;
	}

	/**
	 * Seta o terceiro telefone opcional do cliente
	 * @param telefone3
	 */
	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	/**
	 * Retorna o id da cidade do cliente 
	 * @return cidadeId
	 */
	public Integer getCidadeId() {
		return cidadeId;
	}

	/**
	 * Seta o id da cidade do cliente
	 * @param cidadeId
	 */
	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
}
