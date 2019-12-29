package com.nelioalves.mc.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.domain.ItemPedido;
import com.nelioalves.mc.domain.PagamentoComBoleto;
import com.nelioalves.mc.domain.Pedido;
import com.nelioalves.mc.domain.enuns.EstadoPagamento;
import com.nelioalves.mc.repositories.ItemPedidoRepository;
import com.nelioalves.mc.repositories.PagamentoRepository;
import com.nelioalves.mc.repositories.PedidoRepository;
import com.nelioalves.mc.security.UserSS;
import com.nelioalves.mc.services.exceptions.AuthorizationException;
import com.nelioalves.mc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de serviço da entidade pedido
 * 
 * @author Adriano Rocha
 * @since 13/10/2019
 */

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	/**
	 * Retorna um pedido pelo seu id
	 * 
	 * @param id
	 * @return pedido
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date());
		pedido.setCliente(clienteService.find(pedido.getCliente().getId()));
		pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if (pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante());
		}
		pedido = pedidoRepository.save(pedido);
		pagamentoRepository.save(pedido.getPagamento());
		for (ItemPedido ip : pedido.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(pedido);
		}
		itemPedidoRepository.saveAll(pedido.getItens());
		emailService.sendOrderConfirmationHtmlEmail(pedido);
		return pedido;
	}

	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente =  clienteService.find(user.getId());
		return pedidoRepository.findByCliente(cliente, pageRequest);
	}

}
