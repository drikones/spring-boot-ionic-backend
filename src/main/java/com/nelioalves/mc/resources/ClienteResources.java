package com.nelioalves.mc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.dto.ClienteDTO;
import com.nelioalves.mc.dto.ClienteNewDTO;
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
	
	@GetMapping(value="/email")
	public ResponseEntity<Cliente> find(@RequestParam(value="value") String email) {
		Cliente cliente = clienteService.findByEmail(email);
		return ResponseEntity.ok().body(cliente);
	}
	
	/**
	 * Insere um novo cliente
	 * 
	 * @param clienteNewDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO clienteNewDTO){
		Cliente cliente = clienteService.fromDTO(clienteNewDTO);
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
	@PreAuthorize("hasAnyRole('ADMIN')")
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
	@PreAuthorize("hasAnyRole('ADMIN')")
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
	@PreAuthorize("hasAnyRole('ADMIN')")
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
	
	/**
	 * Endpoint responsável pelo upload da imagem do perfil do cliente ao Amazon S3
	 * @param file
	 * @return
	 */
	@PostMapping(value="/picture")
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file){
		URI uri = clienteService.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
	
			
}
