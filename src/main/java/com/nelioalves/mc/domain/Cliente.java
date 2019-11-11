package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelioalves.mc.domain.enuns.TipoCliente;

/**
 * Classe de domínio do cliente
 * 
 * @author Adriano Rocha
 * @since 27/07/2019
 *
 */
@Entity
public class Cliente  implements Serializable{

	private static final long serialVersionUID = -6512628628220985553L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Column(unique=true)
	private String email;
	private String cpfOuCnpj;
	private Integer tipo;
	
	
	@OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos = new ArrayList<>();
	
	/**
	 * Construtor sem parâmetros
	 */
	public Cliente() {}
	
	/**
	 * Construtor com parâmetros
	 * 
	 * @param id
	 * @param nome
	 * @param email
	 * @param cpfOuCnpj
	 * @param tipo
	 */
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = (tipo==null)? null : tipo.getCod();
	}


	/**
     * Retorna o id
     * @return id
     */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
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
	 * Retorna o email do cliente
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Seta o email do cliente
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
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}
	
	/**
	 * Seta o tipo do cliente
	 * @param tipo
	 */
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna os enderecos associados aquele Cliente
	 * @return enderecos
	 */
    public List<Endereco> getEnderecos() {
		return enderecos;
	}

    /**
     * Seta os enderecos associados aquele Cliente
     * @param enderecos
     */
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	/**
	 * Retorna a lista de telefones do Cliente
	 * @return telefones
	 */
	public Set<String> getTelefones() {
		return telefones;
	}

	/**
	 * Seta a lista de telefones do cliente
	 * @param telefones
	 */
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	/**
	 *  Retorna a lista de pedidos do cliente
	 * @return pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * Seta a lista de pedidos do cliente
	 * @param pedidos
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
