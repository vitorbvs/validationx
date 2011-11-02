package com.validationx.test;

import static com.validationx.Message.*;
import static com.validationx.core.ExpressionUtils.required;
import static com.validationx.factory.ValidationFactory.begin;

import org.junit.Test;

import com.validationx.exceptions.ValidationException;


public class ValidationRequiredExpressionsTests { 
	
	@Test (expected = RuntimeException.class)
	public void deveValidarUmaInstanceDeValidationExpression() {
		begin()
			.that(null);
	}

	@Test (expected = ValidationException.class)
	public void deveValidarObjetosRequired() {
		begin()
			.that(required(null, createMessage("Campo Obrigatório")))
			.checkConstraints();
	}
	
	@Test (expected = ValidationException.class)
	public void deveValidarStringsRequired() {
		begin()
			.that(required("", createMessage("Campo Obrigatório")))
			.checkConstraints();
	}
	
	@Test
	public void devePassarEmTodasAsConstraints() {		
		begin()
			.that(required("Nome válido", null))
			.checkConstraints();
	}
	
	
}