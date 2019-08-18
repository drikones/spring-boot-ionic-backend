package com.nelioalves.mc.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe de domínio da chave primária do Item de pedido
 * 
 * @author Adriano Rocha
 * @since 18/08/2019
 *
 */
@Embeddable
public class ItemPedidoPK implements Serializable{
	
	private static final long serialVersionUID = -3848095832735552671L;
	
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	/**
	 * Retorna o pedido
	 * @return pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}
	
	/**
	 * Informa o pedido
	 * @param pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	/**
	 * Retorna o produto
	 * @return produto
	 */
	public Produto getProduto() {
		return produto;
	}
	
	/**
	 * Informa o produto
	 * @param produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		ItemPedidoPK other = (ItemPedidoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
}
