package com.nelioalves.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.dto.ClienteDTO;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.services.exceptions.DataIntegrityException;
import com.nelioalves.mc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de serviço da entidade Cliente
 * 
 * @author Adriano Rocha
 * @since 04/08/2019
 */
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Busca o cliente por id
	 * 
	 * @param Id
	 * @return cliente
	 */
	public Cliente find(Integer Id) {
		Optional<Cliente> cliente = clienteRepository.findById(Id);
		return cliente.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + Id + ", Tipo: " + Cliente.class.getName()));
	}
	
	/**
	 * Insere um cliente
	 * 
	 * @param cliente
	 * @return clienteRepository.save(cliente);
	 */
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		return clienteRepository.save(cliente);
	}

	/**
	 * Atualiza um cliente
	 * 
	 * @param cliente
	 * @return
	 */
	public Cliente update(Cliente cliente) {
		Cliente newCliente = find(cliente.getId());
		updateData(newCliente,cliente);
		return clienteRepository.save(newCliente);
	}

	/**
	 * 
	 * Deleta um cliente
	 * @param id
	 */
	public void delete (Integer id) {
		Cliente cliente  = find(id);
		if( cliente != null)
		{
			try 
			{
				clienteRepository.delete(cliente);
			}catch(DataIntegrityViolationException ex) {
				throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
			}
		}
	}
	
	/**
	 * Retorna todas os clientes
	 * @return categoriaRepository.findAll()
	 */
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	/**
	 * Realiza a paginação dos clientes
	 * 
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return clientesRepository.findAll(pageRequest)
	 */
	public Page<Cliente> findPage(Integer page,Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}
	
	/**
	 * Converte um objeto DTO em um objeto Cliente
	 * 
	 * @param clienteDTO
	 * @return
	 */
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
	}
	
	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}
	
}
