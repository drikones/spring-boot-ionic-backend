package com.nelioalves.mc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Estado;
import com.nelioalves.mc.repositories.EstadoRepository;

/**
 * Classe de serviço de busca de estados
 * @author Adriano Rocha
 * @since 15/04/2020
 */
@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		return estadoRepository.findAllByOrderByNome();
	}
}