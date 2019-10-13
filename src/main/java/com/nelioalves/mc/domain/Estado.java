package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe de domínio do Estado
 * 
 * @author Adriano Rocha
 * @since 27/07/2019 
 *
 */
@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = -1675576769888859872L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	/**
	 * Construtor sem parâmetros
	 */
	public Estado() {}
	
	/**
	 * Construtor com parâmetros
	 * @param id
	 * @param nome
	 */
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	/**
	 * retorna o id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * seta o id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * retorna o nome do estado
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome do estado
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna a lista de cidades 
	 * @return cidades
	 */
	public List<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * Seta a lista de cidades
	 * @param cidades
	 */
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
