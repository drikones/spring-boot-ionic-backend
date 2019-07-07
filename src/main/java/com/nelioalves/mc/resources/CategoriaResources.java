package com.nelioalves.mc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String listar() {
		return "REST está funcionando";
	}

}
