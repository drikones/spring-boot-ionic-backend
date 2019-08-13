package com.nelioalves.mc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.nelioalves.mc.domain.enuns.EstadoPagamento;

/**
 *  Classe de domínio do pagamento do boleto
 * @author Adriano Rocha
 *
 */
@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 6680594056387384147L;
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento  = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	/**
	 * Retorna a data de vencimento do Boleto
	 * @return dataVencimento
	 */
	public Date getDataVencimento() {
		return dataVencimento;
	}

	/**
	 * Informa a data de vencimento do boleto
	 * @param dataVencimento
	 */
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	/**
	 * Retorna a data de pagamento do boleto
	 * @return dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * Informa a data de pagamento do boleto
	 * @param dataPagamento
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
