package com.nelioalves.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.repositories.ClienteRepository;
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

}
