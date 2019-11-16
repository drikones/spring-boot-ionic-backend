package com.nelioalves.mc.services.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Anotação específica para validação de email do cliente na operação de atualização
 * 
 * @author Adriano Rocha
 * @since 16/11/2019
 *
 */
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy=ClienteUpdateValidator.class)
public @interface ClienteUpdate {
	String message() default "Erro de validação";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
