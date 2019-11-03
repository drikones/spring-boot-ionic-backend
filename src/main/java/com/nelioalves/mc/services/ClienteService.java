package com.nelioalves.mc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelioalves.mc.domain.Cidade;
import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.domain.Endereco;
import com.nelioalves.mc.domain.enuns.TipoCliente;
import com.nelioalves.mc.dto.ClienteDTO;
import com.nelioalves.mc.dto.ClienteNewDTO;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.repositories.EnderecoRepository;
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
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepository.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
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
	 * @param clienteDto
	 * @return
	 */
	public Cliente fromDTO(ClienteDTO clienteDto) {
		return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), null, null);
	}
	
	/**
	 * Converte um objeto DTO em um objeto Cliente para inserção
	 * 
	 * @param clienteNewDTO
	 * @return
	 */
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}
	
}
