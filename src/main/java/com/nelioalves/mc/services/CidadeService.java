package com.nelioalves.mc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Cidade;
import com.nelioalves.mc.repositories.CidadeRepository;

/**
 * Classe de serviço de busca por cidades
 * @author Adriano Rocha
 * @since 15/04/2020
 */
@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> findByEstado(Integer estadoId) {
		return cidadeRepository.findCidades(estadoId);
	}
}
