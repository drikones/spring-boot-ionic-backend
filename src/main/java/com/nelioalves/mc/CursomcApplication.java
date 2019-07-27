package com.nelioalves.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.domain.Cidade;
import com.nelioalves.mc.domain.Estado;
import com.nelioalves.mc.domain.Produto;
import com.nelioalves.mc.repositories.CategoriaRepository;
import com.nelioalves.mc.repositories.CidadeRepository;
import com.nelioalves.mc.repositories.EstadoRepository;
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
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		repoCategoria.saveAll(Arrays.asList(cat1,cat2));
		repoProduto.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.setCidades(Arrays.asList(c1));
		est2.setCidades(Arrays.asList(c2,c3));
		
		repoEstado.saveAll(Arrays.asList(est1,est2));
		repoCidade.saveAll(Arrays.asList(c1,c2,c3));
		
	}
	
	

}
