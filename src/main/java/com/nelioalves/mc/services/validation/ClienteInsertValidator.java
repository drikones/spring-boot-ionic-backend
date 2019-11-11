package com.nelioalves.mc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.nelioalves.mc.domain.Cliente;
import com.nelioalves.mc.domain.enuns.TipoCliente;
import com.nelioalves.mc.dto.ClienteNewDTO;
import com.nelioalves.mc.repositories.ClienteRepository;
import com.nelioalves.mc.resources.exceptions.FieldMessage;
import com.nelioalves.mc.services.validation.utils.BR;

/**
 * Validador que será usado pela anotação para validar o cpf, cnpj e o email do cliente
 * 
 * @author Adriano Rocha
 * @since 10/11/2019
 * 
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void initialize(ClienteInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) 
		{	
			list.add(new FieldMessage("cpfOuCnpj", "CPF não é valido!"));
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) 
		{
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ não é valido!"));
		}
		
		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if( aux != null) {
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
