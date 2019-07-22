package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Classe de domínio do produto
 * 
 * @author Adriano Rocha
 * @since 21/07/2019
 */

@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = -6418335213073059447L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
				joinColumns = @JoinColumn(name = "produto_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	/**
	 * Construtor sem argumentos
	 */
	public Produto() {}
	
	/**
	 * Construtor com argumentos
	 * 
	 * @param id
	 * @param nome
	 * @param preco
	 */
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	/**
	 * Retorna o id
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
	 * retorna o nome
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * seta o nome
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * retorna o preco
	 * @return preco
	 */
	public Double getPreco() {
		return preco;
	}
	/**
	 * seta o preco
	 * @param preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Retorna as categorias para um produto
	 * @return categorias
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Seta as categorias para um produto
	 * @param categorias
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	 

}
