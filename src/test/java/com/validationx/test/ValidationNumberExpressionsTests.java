package com.validationx.test;

import static com.validationx.Message.createMessage;
import static com.validationx.core.ExpressionUtils.*;
import static com.validationx.factory.ValidationFactory.begin;

import org.junit.Test;

import com.validationx.exceptions.ValidationException;


public class ValidationNumberExpressionsTests {
	
	@Test (expected = ValidationException.class)
	public void deveValidarNumeroInvalidoEspacoEmBranco() {
		begin()
			.that(number(" ", createMessage("N�mero Inv�lido")))
			.checkConstraints();
	}
	
	@Test (expected = ValidationException.class)
	public void deveValidarNumeroInvalidoEspacoVazio() {
		begin()
			.that(number("", createMessage("N�mero Inv�lido")))
			.checkConstraints();
	}
	
	@Test (expected = ValidationException.class)
	public void deveValidarNumeroInvalidoNulo() {
		begin()
			.that(number(null, createMessage("N�mero inv�lido")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarNumeroLongValido() {
		begin()
			.that(number(10L, createMessage("N�mero V�lido")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarNumeroIntegerValido() {
		begin()
			.that(number(10, createMessage("N�mero v�lido")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarNumeroStringValido() {
		begin()
			.that(number("1", createMessage("N�mero como string v�lido")))
			.checkConstraints();
	}
	
	@Test(expected = ValidationException.class)
	public void deveValidarSizeInvalido() {
		begin()
			.that(size(20, 0, 10, createMessage("N�mero e pah")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarSizeValido() {
		begin()
			.that(size(15, 5, 15, createMessage("Numero e pah")))
			.checkConstraints();
	}
	
	@Test
	public void deveValidarMinimoValido() {
		begin()
			.that(min(0, 0, createMessage("N�mero e pah")))
			.checkConstraints();
	}
	
	@Test(expected = ValidationException.class)
	public void deveValidarMinimoInvalido() {
		begin()
			.that(min(0, 1, createMessage("N�mero e pah")))
			.that(min(1,1, createMessage("N�mero e path")))
			.checkConstraints();
	}

	@Test
	public void deveValidarMaximoValido() {
		begin()
			.that(max(9, 10, createMessage("N�mero e pah")))
			.that(max(10,10, createMessage("N�mero e path")))
			.checkConstraints();
	}
	
	@Test(expected = ValidationException.class)
	public void deveValidarMaximoInvalido() {
		begin()
			.that(max(11, 10, createMessage("N�mero e pah")))
			.checkConstraints();
	}
	
}
