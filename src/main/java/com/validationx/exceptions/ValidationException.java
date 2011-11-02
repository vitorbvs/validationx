package com.validationx.exceptions;

import com.validationx.core.Validation;

/**
 * Exceção lançada quando uma validação, qualquer que seja, seja inválida.
 * @author Ellison
 *
 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Validation validation;
	
	public ValidationException(Validation validation) {
		this.validation = validation;
	}

	public Validation getValidation() {
		return validation;
	}

}
