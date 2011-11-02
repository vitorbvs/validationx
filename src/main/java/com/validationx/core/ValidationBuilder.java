package com.validationx.core;

import com.validationx.Expression;
import com.validationx.exceptions.ValidationException;

/**
 * Define o conjunto de valida��es e as executa.
 * 
 * @author Ellison
 *
 */
public class ValidationBuilder extends Validation {
	
	/**
	 * Valida se um objeto qualquer � nulo.
	 * Caso a senten�a seja verdadeira, uma mensagem � armazenada na lista de messages. 
	 * 
	 * @param expression
	 * @param placeHolders
	 * @return <b>true</b> se object for igual a null, caso contr�rio, false.
	 */
	public ValidationBuilder that(Expression expression) throws RuntimeException {
		if (expression == null)
			throw new RuntimeException("� Obrigat�rio passar um Expression");
		
		return (ValidationBuilder) evaluate(expression);
	}

	/**
	 * Executa todas as valida��es declaradas anteriormente.
	 * Se existirem erros, {@link ValidationException} � lan�ada.
	 * 
	 * @return
	 */
	public ValidationBuilder checkConstraints() throws ValidationException {
		if (hasErrors()) {
			throw new ValidationException(this);
		}
		
		return this;
	}
	
}