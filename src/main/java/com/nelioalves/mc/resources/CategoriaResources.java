package com.nelioalves.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.services.CategoriaService;

/**
 * classe responsável pela funcionalidade de controller das categorias
 * 
 * @author Adriano Rocha
 * @since 07/07/2019
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
	
	
	@Autowired
	private CategoriaService categoriaService;

	/**
	 * método responsável por buscar categorias por id
	 * 
	 * @author Adriano Rocha
	 * @since 07/07/2019
	 */
	@GetMapping(value= "/{id}")
	public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Integer id) {
		Categoria categoria = categoriaService.buscar(id);
		return ResponseEntity.ok().body(categoria);
	}

}
