package com.nelioalves.mc.dto;

import java.io.Serializable;

import com.nelioalves.mc.domain.Estado;

public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 2872403282931754744L;
	private Integer id;
	private String nome;

	public EstadoDTO() {
	}

	public EstadoDTO(Estado estado) {
		id = estado.getId();
		nome = estado.getNome();
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
