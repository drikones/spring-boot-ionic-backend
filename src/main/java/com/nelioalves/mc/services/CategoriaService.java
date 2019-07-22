package com.nelioalves.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.repositories.CategoriaRepository;
import com.nelioalves.mc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de serviços da entidade categoria que acessam os métodos da minha
 * camada de acesso a dados
 * 
 * @author Adriano Rocha
 * @since 09/07/2019
 */
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	/**
	 * retorna uma categoria por id
	 * 
	 * @param Id
	 * @return categoria
	 */
	public Categoria buscar(Integer Id) {
		Optional<Categoria> categoria = categoriaRepository.findById(Id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + Id + ", Tipo: " + Categoria.class.getName()));
	}

}
