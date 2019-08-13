package com.nelioalves.mc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.nelioalves.mc.domain.enuns.EstadoPagamento;

/**
 * Classe de domínio do pagamento
 * 
 * @author Adriano Rocha
 * @since 08/04/2019
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

	private static final long serialVersionUID = 7120851864977982461L;
	
	@Id
	private Integer id;
	

	private Integer estado;
	
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId
	private Pedido pedido;
	
	/**
	 * Construtor de Pagamento sem parâmetros
	 */
	public Pagamento() {}

	/**
	 * Construtor de Pagamento com parâmetros
	 * 
	 * @param id
	 * @param estado
	 * @param pedido
	 */
	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}
	
	/**
	 * Retorna o id do pagamento
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o id do pagamento
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o status do pagamento
	 * @return estado
	 */
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	/**
	 * Seta o status do pagamento
	 * @param estado
	 */
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	/**
	 * Retorna o pedido atrelado ao pagamento
	 * @return pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Informa o pedido atrelado ao pagamento
	 * @param pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
