package com.nelioalves.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.domain.Produto;
import com.nelioalves.mc.repositories.CategoriaRepository;
import com.nelioalves.mc.repositories.ProdutoRepository;
import com.nelioalves.mc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de serviço da entidade produto
 * 
 * @author Adriano Rocha
 * @since 16/11/2019
 */
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/**
	 * Retorna um produto pelo seu id
	 * 
	 * @param id
	 * @return produto
	 */
	public Produto find(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	/**
	 * Faz a paginação  de produtos que contém o trecho de nome dado e que pertencem a pelo menos uma das
     * categorias dadas
	 * 
	 * @param nome
	 * @param ids
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	public Page<Produto> search(String nome, List<Integer> idsInteger, Integer page, Integer linesPerPage, String orderBy, String direction)
	{
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(idsInteger);
		return produtoRepository.search(nome,categorias,pageRequest);
	}

}

