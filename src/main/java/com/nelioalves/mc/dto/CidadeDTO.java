package com.nelioalves.mc.dto;

import java.io.Serializable;

import com.nelioalves.mc.domain.Cidade;

/**
 * DTO para o endpoint de cidades
 * @author Adriano Rocha
 * @since 15/04/2020
 */
public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 2162693291547611154L;
	private Integer id;
	private String nome;

	public CidadeDTO() {
	}

	public CidadeDTO(Cidade cidade) {
		id = cidade.getId();
		nome = cidade.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
