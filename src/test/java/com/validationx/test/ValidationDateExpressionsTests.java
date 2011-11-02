package com.validationx.test;


import static com.validationx.Message.createMessage;
import static com.validationx.core.ExpressionUtils.dateAfter;
import static com.validationx.factory.ValidationFactory.begin;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.validationx.exceptions.ValidationException;


public class ValidationDateExpressionsTests {
	
	@Test (expected = ValidationException.class)
	public void deveValidarDataInicioMenorQueDataFinal() {
		Calendar calendar = Calendar.getInstance();
		Date dataInicio = calendar.getTime();
		
		calendar.add(Calendar.DAY_OF_WEEK, -2);
		Date dataFinal = calendar.getTime();
		
		begin()
			.that(dateAfter(dataInicio, dataFinal, createMessage("Data Inválida")))
			.checkConstraints();
	}

}
