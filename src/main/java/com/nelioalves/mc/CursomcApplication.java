package com.nelioalves.mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.domain.Cidade;
import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.domain.Endereco;
import com.nelioalves.mc.domain.Estado;
import com.nelioalves.mc.domain.ItemPedido;
import com.nelioalves.mc.domain.Pagamento;
import com.nelioalves.mc.domain.PagamentoComBoleto;
import com.nelioalves.mc.domain.PagamentoComCartao;
import com.nelioalves.mc.domain.Pedido;
import com.nelioalves.mc.domain.Produto;
import com.nelioalves.mc.domain.enuns.EstadoPagamento;
import com.nelioalves.mc.domain.enuns.TipoCliente;
import com.nelioalves.mc.repositories.CategoriaRepository;
import com.nelioalves.mc.repositories.CidadeRepository;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.repositories.EnderecoRepository;
import com.nelioalves.mc.repositories.EstadoRepository;
import com.nelioalves.mc.repositories.ItemPedidoRepository;
import com.nelioalves.mc.repositories.PagamentoRepository;
import com.nelioalves.mc.repositories.PedidoRepository;
import com.nelioalves.mc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Autowired
	private ProdutoRepository repoProduto;
	
	@Autowired
	private EstadoRepository repoEstado;
	
	@Autowired
	private CidadeRepository repoCidade;
	
	@Autowired
	private ClienteRepository repoCliente;
	
	@Autowired
	private EnderecoRepository repoEndereco;
	
	@Autowired
	private PedidoRepository repoPedido;
	
	@Autowired
	private PagamentoRepository repoPagamento;
	
	@Autowired
	private ItemPedidoRepository repoItemPedido;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama, Mesa e Banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		repoCategoria.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.setCidades(Arrays.asList(c1));
		est2.setCidades(Arrays.asList(c2,c3));
		
		repoEstado.saveAll(Arrays.asList(est1,est2));
		repoCidade.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220384", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.setEnderecos(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
  		ped2.setPagamento(pagto2);
  		
  		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
  		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
  		cli1.setPedidos(Arrays.asList(ped1,ped2));
  		
  		repoCliente.saveAll(Arrays.asList(cli1));
		repoEndereco.saveAll(Arrays.asList(e1,e2));
		repoPedido.saveAll(Arrays.asList(ped1,ped2));
		repoProduto.saveAll(Arrays.asList(p1,p2,p3));
		repoItemPedido.saveAll(Arrays.asList(ip1,ip2,ip3));
		repoPagamento.saveAll(Arrays.asList(pagto1,pagto2));
		
		
	}
	
	

}
