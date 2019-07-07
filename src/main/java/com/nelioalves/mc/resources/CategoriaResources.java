package com.nelioalves.mc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.mc.domain.Categoria;

/**
 * classe responsável pela funcionalidade de controller das categorias
 * 
 * @author Adriano Rocha
 * @since 07/07/2019
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

	/**
	 * método responsável pela listagem das categorias
	 * 
	 * @author Adriano Rocha
	 * @since 07/07/2019
	 */
	@GetMapping
	public List<Categoria> listar() {
		 Categoria cat1 = new Categoria(1, "Escritório");
		 Categoria cat2 = new Categoria(2, "Informática");
		 
		 List<Categoria> categorias = new ArrayList<>();
		 categorias.add(cat1);
		 categorias.add(cat2);
		 
		 return categorias;
	}

}
