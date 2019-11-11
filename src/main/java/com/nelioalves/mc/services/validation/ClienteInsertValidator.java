package com.nelioalves.mc.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nelioalves.mc.domain.enuns.TipoCliente;
import com.nelioalves.mc.dto.ClienteNewDTO;
import com.nelioalves.mc.resources.exceptions.FieldMessage;
import com.nelioalves.mc.services.validation.utils.BR;
/**
 * Validador que será usado pela anotação para validar o cpf e o cnpj do cliente
 * 
 * @author Adriano Rocha
 * @since 10/11/2019
 * 
 */
public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Override
	public void initialize(ClienteInsert constraintAnnotation) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		System.err.println("CPF é: "+BR.isValidCPF(objDto.getCpfOuCnpj()));
		System.err.println("CNPJ é: "+BR.isValidCPF(objDto.getCpfOuCnpj()));
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) 
		{	
			list.add(new FieldMessage("cpfOuCnpj", "CPF não é valido!"));
		}
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) 
		{
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ não é valido!"));
		} 
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
