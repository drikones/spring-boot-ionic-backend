package com.nelioalves.mc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.dto.ClienteDTO;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.resources.exceptions.FieldMessage;

/**
 * Validador que será usado pela anotação para validar o email e o email do cliente ao atualizar ele
 * 
 * @author Adriano Rocha
 * @since 16/11/2019
 * 
 */
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Override
	public void initialize(ClienteUpdate constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClienteDTO clienteDto, ConstraintValidatorContext context) {
       
		@SuppressWarnings("unchecked")
		Map<String,String> map = (Map<String,String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = clienteRepository.findByEmail(clienteDto.getEmail());
		if( aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "E-mail já existente no sistema"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
