package com.nelioalves.mc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe de domínio do Endereço
 * 
 * @author Adriano Rocha
 * @since 27/07/2019
 */
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = -1631052515472579122L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	/**
	 * Construtor sem parâmetros
	 */
	public Endereco() {}
	
	/**
	 * Construtor com parâmetros
	 * 
	 * @param id
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cep
	 * @param cliente
	 */
	public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep,
			Cliente cliente, Cidade cidade) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.cidade = cidade;
	}

	/**
	 * Retorna o id do Endereco
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do Endereco
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Retorna o Logradouro do Endereco
	 * @return logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}
	
	/**
	 * Seta o logradouro do Endereco
	 * @param logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	/**
	 * Retorna o numero do Endereco
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Seta o numero do Endereco
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	/**
	 * Retorna o complemento do Endereco
	 * @return complemento
	 */
	public String getComplemento() {
		return complemento;
	}
	
	/**
	 * Seta o complemento do Endereco
	 * @param complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	/**
	 * Retorna o bairro do endereco
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}
	
	/**
	 * Seta o bairro do Endereco
	 * @param bairro
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	/**
	 * Retorna o cep do Endereco
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}
	
	/**
	 * Seta o cep do Endereco
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	/**
	 * Retorna o cliente associado aquele Endereco
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Seta o cliente para aquele Endereco
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Retorna a cidade associada ao Endereco
	 * @return cidade
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Seta a cidade associada ao Endereco
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
