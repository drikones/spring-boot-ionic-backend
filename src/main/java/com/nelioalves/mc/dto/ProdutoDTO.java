package com.nelioalves.mc.dto;

import java.io.Serializable;

import com.nelioalves.mc.domain.Produto;


/**
 * Classe de DTO que vai retornar apenas as informações de Produto 
 *  
 * 
 * @author Adriano Rocha
 * @since 16/11/2019
 */
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 6687723854987245657L;
	private Integer id;
	private String nome;
	private Double preco;
	
	/**
	 * Connstrutor do DTO de Produto sem argumentos
	 */
	public ProdutoDTO() {}
	
	/**
	 * Construtor do DTO do produto com um objeto do domínio de produto como argumento
	 * @param produto
	 */
	public ProdutoDTO(Produto produto) 
	{
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}
	
	
	/**
	 * Retorna o id do produto
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Seta o id do produto
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Retorna o nome do produto
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Seta o nome do produto
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Retorna o preço do produto
	 * @return preco
	 */
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Seta o preço do produto
	 * @param preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
