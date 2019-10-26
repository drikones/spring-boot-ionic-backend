package com.nelioalves.mc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.mc.domain.Categoria;
import com.nelioalves.mc.dto.CategoriaDTO;
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
	
	/**
	 * Método responsável por fazer uma requisição HTTP delete para deletar uma Categoria
	 * 
	 * @param id
	 * @return
	 * 
	 * @author Adriano Rocha
	 * @since 20/10/2019
	 */
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Método responsável por listar todas as categorias
	 * 
	 * @return
	 * 
	 * @author Adriano Rocha
	 * @since 26/10/2019
	 * 
	 */
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	/**
	 * Endpoint responsável por fazer a paginação das categorias
	 * 
	 * 
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return pageDTO
	 * 
	 * 
	 * @author Adriano Rocha
	 * @since  26/10/2019
	 * 
	 */
	@GetMapping(value="/page")
	public ResponseEntity<Page<CategoriaDTO>> findPage(
			@RequestParam(value="page",defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="nome") String orderBy,
			@RequestParam(value="direction",defaultValue="ASC") String direction){
		Page<Categoria> pageCategoria = categoriaService.findPage(page,linesPerPage,orderBy,direction);
		Page<CategoriaDTO> pageDTO = pageCategoria.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(pageDTO);
	}
	
}
