package com.validationx.exceptions;

import com.validationx.core.Validation;

/**
 * Exce��o lan�ada quando uma valida��o, qualquer que seja, seja inv�lida.
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
