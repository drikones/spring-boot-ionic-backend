package com.nelioalves.mc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.mc.domain.Categoria;

/**
 * Classe de DTO que vai retornar apenas as informações de Categoria, 
 * sem os seus produtos associados para cada categoria 
 * 
 * @author Adriano Rocha
 * @since 26/10/2019
 */
public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = -8551744337327939547L;
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5,max=80, message="O nome deve conter de 5 a 80 caracteres")
	private String nome;
	
	/**
	 * Construtor do DTO de Categoria sem argumentos
	 */
	public CategoriaDTO() {}
	
	
	/**
	 * Construtor do DTO de categoria com argumentos
	 * 
	 * @param categoria
	 */
	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}

	/**
	 * Retorna o id da categoria
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id de uma Categoria
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Retorna o nome de uma categoria
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 *  Seta o nome de uma categoria
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
