package com.nelioalves.mc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nelioalves.mc.services.DBService;
import com.nelioalves.mc.services.EmailService;
import com.nelioalves.mc.services.SmtpEmailService;

/**
 *  Classe de configuração para o profile de testes
 *  
 * @author Adriano Rocha
 * @since 17/11/2019
 */
@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if(strategy.equals("create")) {
			dbService.instantiateTestDatabase();
			return true;
		}else {
			return false;
		}
		
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
