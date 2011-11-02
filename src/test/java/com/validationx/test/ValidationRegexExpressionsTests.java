package com.validationx.test;

import static com.validationx.Message.*;
import static com.validationx.core.ExpressionUtils.regex;
import static com.validationx.factory.ValidationFactory.begin;

import org.junit.Test;

import com.validationx.exceptions.ValidationException;


public class ValidationRegexExpressionsTests {
	
	@Test (expected = ValidationException.class)
	public void deveValidarExpressaoRegularInvalida() {
		begin()
			.that(regex("[A-Z]", "ellison", createMessage("Expressao Invalida")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarExpressaoRegularValida() {
		begin()
			.that(regex("[A-Z]", "ELLISON", createMessage("")))
			.checkConstraints();
	}

}
