package com.nelioalves.mc.domain;

import javax.persistence.Entity;

import com.nelioalves.mc.domain.enuns.EstadoPagamento;

/**
 * Classe de dominio do pagamento com cartao
 * @author Adriano Rocha
 *
 */
@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 2000022512598229581L;
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	/**
	 * Retorna o numero de parcelas
	 * @return numerDeParcelas
	 */
	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	/**
	 * Informa o numero de parcelas
	 * @param numeroDeParcelas
	 */
	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
