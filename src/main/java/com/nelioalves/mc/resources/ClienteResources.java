package com.nelioalves.mc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.dto.ClienteDTO;
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
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente cliente = clienteService.find(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	/**
	 * Insere um novo cliente
	 * 
	 * @param clienteDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ClienteDTO clienteDTO){
		Cliente cliente = clienteService.fromDTO(clienteDTO);
		cliente = clienteService.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Atualiza um cliente
	 * 
	 * @param clienteDTO
	 * @param id
	 * @return
	 */
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id)
	{
	    Cliente cliente = clienteService.fromDTO(clienteDTO);
		cliente.setId(id);
		cliente = clienteService.update(cliente);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Deleta um cliente pelo seu id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id)
	{
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
	/**
	 * 
	 * Lista a todos os clientes
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> clientes = clienteService.findAll();
		List<ClienteDTO> clientesDTO = clientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(clientesDTO);
	}
	
	
	/**
	 * 
	 * Faz a paginação de todos os clientes
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 */
	@GetMapping(value="/page")
	public ResponseEntity<Page<ClienteDTO>> findPage
	(
			@RequestParam(value="page",defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue="nome") String orderBy,
			@RequestParam(value="direction",defaultValue="ASC") String direction
	)
	{
		Page<Cliente> pageCliente = clienteService.findPage(page,linesPerPage,orderBy,direction);
		Page<ClienteDTO> pageDTO = pageCliente.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(pageDTO);
	}
			
}
