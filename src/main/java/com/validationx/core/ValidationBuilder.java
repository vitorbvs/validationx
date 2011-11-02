package com.validationx.core;

import com.validationx.Expression;
import com.validationx.exceptions.ValidationException;

/**
 * Define o conjunto de validações e as executa.
 * 
 * @author Ellison
 *
 */
public class ValidationBuilder extends Validation {
	
	/**
	 * Valida se um objeto qualquer é nulo.
	 * Caso a sentença seja verdadeira, uma mensagem é armazenada na lista de messages. 
	 * 
	 * @param expression
	 * @param placeHolders
	 * @return <b>true</b> se object for igual a null, caso contrário, false.
	 */
	public ValidationBuilder that(Expression expression) throws RuntimeException {
		if (expression == null)
			throw new RuntimeException("É Obrigatório passar um Expression");
		
		return (ValidationBuilder) evaluate(expression);
	}

	/**
	 * Executa todas as validações declaradas anteriormente.
	 * Se existirem erros, {@link ValidationException} é lançada.
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