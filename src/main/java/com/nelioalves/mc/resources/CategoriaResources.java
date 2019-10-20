package com.nelioalves.mc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 * @param id
	 * 
	 * @author Adriano Rocha
	 * @since 07/07/2019
	 */
	@GetMapping(value= "/{id}")
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria categoria = categoriaService.find(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	/**
	 * método responsável por inserir uma categoria no banco
	 * 
	 * @param categoria
	 * 
	 * @author Adriano Rocha
	 * @since 20/10/2019
	 * 
	 * 
	 */
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Atualiza uma categoria passada no corpo de uma requisição
	 * 
	 * @param id, categoria
	 * 
	 * @author Adriano Rocha
	 * @since 20/10/2019
	 * 
	 */
	@PutMapping(value="/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Integer id){
    	categoria.setId(id);
    	categoria = categoriaService.update(categoria);
    	return ResponseEntity.noContent().build();
    }
	
}
