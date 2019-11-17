package com.nelioalves.mc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.mc.domain.Pedido;
import com.nelioalves.mc.services.PedidoService;

/**
 * Controller responsável por processar as requisições HTTP referente ao domínio de Pedido
 * @author Adriano Rocha
 * @since 13/10/2019
 *
 */

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	/**
	 * Busca o pedido por id
	 * 
	 * @param id
	 * @return pedido
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> find( @PathVariable Integer id) {
		Pedido pedido = pedidoService.find(id);
		return ResponseEntity.ok().body(pedido);
	}
	
	/**
	 * método responsável por inserir um pedido no banco
	 * 
	 * @param categoria
	 * 
	 * @author Adriano Rocha
	 * 
	 * 
	 */
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido){
		pedido = pedidoService.insert(pedido);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
