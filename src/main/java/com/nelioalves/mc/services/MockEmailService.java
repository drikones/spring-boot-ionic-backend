package com.nelioalves.mc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

/**
 * Classe criada para mockar informações de e-mail para testes
 * @author Adriano Rocha
 * @since 24/11/2019
 *
 */
public class MockEmailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de e-mail");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado");
	}

}
