package com.nelioalves.mc.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * Classe de domínio do pedido
 * 
 * @author Adriano Rocha
 * @since 08/04/2019
 */
@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = -3209750273837916157L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	
	@OneToOne(cascade= CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	@OneToMany(mappedBy="id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	/**
	 * Construtor de Pedido sem parâmetros
	 */
	public Pedido() {}

	/**
	 * Construtor de pedido com parãmetros
	 * 
	 * @param id
	 * @param instante
	 * @param pagamento
	 * @param cliente
	 * @param enderecoDeEntrega
	 */
	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	/**
	 * Retorna o valor total do pedido
	 * @return soma
	 */
	public double getValorTotal(){
		double soma = 0.0;
		for(ItemPedido ip : itens) 
			soma+=ip.getSubTotal();
		return soma;
	}

	/**
	 * Retorna o id do pedido
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Seta o id do pedido
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o instante da solicitação do pedido
	 * @return instante
	 */
	public Date getInstante() {
		return instante;
	}

	/**
	 * Informa o instante da solicitação do pedido
	 * @param instante
	 */
	public void setInstante(Date instante) {
		this.instante = instante;
	}

	/**
	 * Retorna o tipo de pagamento do pedido
	 * @return pagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * Informa o tipo de pagamento do pedido
	 * @param pagamento
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * Retorna quem é o cliente que fez o pedido
	 * @return cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Informa quem é o cliente que fez o pedido
	 * @param cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Retorna qual o endereco de entrega do pedido
	 * @return enderecoDeEntrega
	 */
	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	/**
	 * Inforna qual o endereco de entrega do pedido
	 * @param enderecoDeEntrega
	 */
	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	/**
	 * Retorna os itens do pedido
	 * @return itens
	 */
	public Set<ItemPedido> getItens() {
		return itens;
	}

	/**
	 * Informa os itens do pedido
	 * @param itens
	 */
	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstante()));
		builder.append(", Cliente: ");
		builder.append(getCliente().getNome());
		builder.append(", Situação do pagamento: ");
		builder.append(getPagamento().getEstado().getDescricao());
		builder.append("\nDetalhes:\n");
		for (ItemPedido ip : getItens()) {
			builder.append(ip.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getValorTotal()));
		return builder.toString();
	}
}
