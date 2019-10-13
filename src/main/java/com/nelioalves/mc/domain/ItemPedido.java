package com.nelioalves.mc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe de domínio do item do pedido
 * 
 * @author Adriano Rocha
 * @since 18/08/2019
 */
@Entity
public class ItemPedido implements Serializable {
	
	private static final long serialVersionUID = 7177264728693442070L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	/**
	 * Construtor do ItemPedido sem parâmetros
	 */
	public ItemPedido() {}
	
	/**
	 * Construtor do item de pedido com parâmetros
	 * 
	 * @param pedido
	 * @param produto
	 * @param desconto
	 * @param quantidade
	 * @param preco
	 */
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	/**
	 * Retorna o desconto
	 * @return desconto
	 */
	public Double getDesconto() {
		return desconto;
	}
	
	/**
	 * Informa o desconto
	 * @param desconto
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	/**
	 * Retorna a quantidade
	 * @return quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Informa a quantidade
	 * @param quantidade
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * Retorna o preco
	 * @return preco
	 */
	public Double getPreco() {
		return preco;
	}
	
	/**
	 * Informa o preco
	 * @param preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/**
	 * Retorna o pedido associado ao item
	 * @return id
	 */
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	/**
	 * Retorna o produto associado ao item
	 * @return id
	 */
	public Produto getProduto() {
		return id.getProduto();
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
