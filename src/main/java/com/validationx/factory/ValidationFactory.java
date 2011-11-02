package com.validationx.factory;

import com.validationx.core.ValidationBuilder;

/**
 * F�brica de instancias utilizadas por Validation.
 * @author Ellison
 *
 */
public class ValidationFactory {
	
	/**
	 * Cria uma nova inst�ncia de ValidationBuilder.
	 * @return
	 */
	public static ValidationBuilder begin() {
		return new ValidationBuilder();
	}
	
}