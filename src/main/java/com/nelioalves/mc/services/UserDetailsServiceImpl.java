package com.nelioalves.mc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.security.UserSS;

/**
 * Implementação da interface do Spring Security que permite a busca pelo nome do usuário
 * 
 * @author Adriano Rocha
 * @since 22/12/2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) 
		{
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(cliente.getId(),cliente.getEmail(),cliente.getSenha(), cliente.getPerfis());
	}

}
