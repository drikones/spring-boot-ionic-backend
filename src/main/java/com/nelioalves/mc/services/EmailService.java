package com.nelioalves.mc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.domain.Pedido;

/**
 * Interface que irá definir as operações de enviar a confirmação do pedido e do
 * envio do e-mail
 * 
 * @author Adriano Rocha
 * @since 24/11/2019
 *
 */
public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);

	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}
