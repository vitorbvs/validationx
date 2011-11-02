package com.validationx.factory;

import com.validationx.core.ValidationBuilder;

/**
 * Fábrica de instancias utilizadas por Validation.
 * @author Ellison
 *
 */
public class ValidationFactory {
	
	/**
	 * Cria uma nova instância de ValidationBuilder.
	 * @return
	 */
	public static ValidationBuilder begin() {
		return new ValidationBuilder();
	}
	
}