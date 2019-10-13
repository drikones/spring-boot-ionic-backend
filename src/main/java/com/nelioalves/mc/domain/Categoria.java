package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * Classe de domínio da categoria
 * 
 * @author Adriano Rocha
 * @since 07/07/2019
 */
@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 649113484527835603L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	
	@ManyToMany(mappedBy="categorias")
	private List<Produto> produtos = new ArrayList<>();

	/**
	 * Construtor de categoria sem argumentos
	 */
	public Categoria() {
	}

	/**
	 * Construtor de categoria com argumentos
	 * 
	 * @param id
	 * @param nome
	 */
	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	/**
	 * retorna o id da categoria
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * seta o id da categoria
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * retorna o nome da categoria
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * seta o nome da categoria
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna uma lista de produtos
	 * @return produtos
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Sta uma lista de produtos
	 * @param produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
