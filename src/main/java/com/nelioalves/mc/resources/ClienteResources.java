package com.nelioalves.mc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.services.ClienteService;

/**
 * Controller da entidade cliente 
 * 
 * @author Adriano Rocha
 * @since 08/04/2019
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {
	
	@Autowired
	private ClienteService clienteService;
	
	/**
	 * Busca o cliente por id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscar(id);
		return ResponseEntity.ok().body(cliente);
	}

}
