package com.nelioalves.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
