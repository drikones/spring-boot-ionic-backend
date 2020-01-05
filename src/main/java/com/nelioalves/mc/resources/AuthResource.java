package com.nelioalves.mc.resources;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.mc.security.JWTUtil;
import com.nelioalves.mc.security.UserSS;
import com.nelioalves.mc.services.UserService;

/**
 * Classe de controller responsável por fazer o refresh do token para autenticação 
 * 
 * @author Adriano Rocha
 * @since  05/01/2020	
 *
 */
@RestController
@RequestMapping(value="/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping(value="refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer "+token);
		return ResponseEntity.noContent().build();
	}

}
