package com.nelioalves.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Pedido;
import com.nelioalves.mc.repositories.PedidoRepository;
import com.nelioalves.mc.services.exceptions.ObjectNotFoundException;

/**
 * Classe de serviço da entidade pedido
 * 
 * @author Adriano Rocha
 * @since 13/10/2019
 */

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	/**
	 * Retorna um pedido pelo seu id
	 * 
	 * @param id
	 * @return pedido
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
