package com.nelioalves.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.repositories.CategoriaRepository;
import com.nelioalves.mc.services.exceptions.DataIntegrityException;
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
	public Categoria find(Integer Id) {
		Optional<Categoria> categoria = categoriaRepository.findById(Id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + Id + ", Tipo: " + Categoria.class.getName()));
	}
	
	/**
	 * Insere uma categoria passada no corpo da requisição
	 * 
	 * @param categoria
	 * @return
	 */
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	/**
	 * Atualiza uma categoria passada no corpo da requisição baseada em seu id
	 * 
	 * @param categoria
	 * @return
	 */
	public Categoria update(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	/**
	 * Deleta uma categoria pelo seu id
	 * 
	 * @param id
	 * 
	 */
	public  void delete(Integer id) {
		Categoria categoria = find(id);
		if(categoria != null)
		{
			try
			{
				categoriaRepository.delete(categoria);
			}
			catch(DataIntegrityViolationException ex) 
			{
				throw new DataIntegrityException("Não é possível excluir uma categoria que possua produtos!");
			}
		}	
	}
}
