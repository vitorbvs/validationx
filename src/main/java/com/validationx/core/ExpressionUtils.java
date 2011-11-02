package com.validationx.core;

import static com.validationx.Expression.createExpression;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.validationx.Expression;
import com.validationx.Message;

/**
 * Expressões de validação comumente utilizadas.
 * Ex.: Objeto nulo, datas inválidas, formato de número inválido etc.
 * 
 * @author Ellison
 *
 */
public class ExpressionUtils {
	
	/**
	 * Avalia se uma string é nula ou vazia.
	 * @param string
	 * @param placeHolders
	 * @return
	 */
	public static Expression required(String string, Message message) {
		return createExpression(string == null || string == "", message); 
	}
	
	/**
	 * Avalia se um objeto é nulo.
	 * @param object
	 * @param placeHolders
	 * @return
	 */
	public static Expression required(Object object, Message message) {
		return createExpression(object == null, message);
	}
	
	public static Expression dateAfter(Date mainDate, Date dateToCompare, Message message) {
		return createExpression(mainDate.after(dateToCompare), message);
	}
	
	public static Expression dateBefore(Date mainDate, Date dateToCompare, Message message) {
		return createExpression(mainDate.before(dateToCompare), message);
	}
	
	public static Expression sameDate(Date mainDate, Date dateToCompare, Message message) {
		return createExpression(mainDate.compareTo(dateToCompare) == 0, message);
	}
	
	public static Expression empty(Collection<?> collection, Message message) {
		return createExpression(collection == null || collection.isEmpty(), message);
	}
	
	/**
	 * Utiliza um padrão regex para validar um determinado valor.
	 * @param regex
	 * @param input
	 * @param message
	 * @return
	 */
	public static Expression regex(String regex, String input, Message message) {
		return createExpression(!encontrouTodasAsOcorrencias(regex, input), message);
	}
	
	/**
	 * Avalia se o objeto recebido é um número.
	 * @param object objeto que será validado.
	 * @param message
	 * @return
	 */
	public static Expression number(Object object, Message message) {
		if (object == null) {
			return required(object, message);
		}
		
		if (object instanceof Integer || object instanceof Long) {
			return createExpression(false, message);
		}
		
		if (object instanceof String && object == "") {
			return createExpression(true, message);
		}
		
		return createExpression(!encontrouTodasAsOcorrencias("\\d", String.valueOf(object)), message);
	}
	
	/**
	 * Avalida se o número informado em objectSize atende ao range definido em min e max.
	 * @param objectSize
	 * @param min
	 * @param max
	 * @param message
	 * @return
	 */
	public static Expression size(Integer objectSize, Integer min, Integer max, Message message) {
		return createExpression(!(objectSize >= min && objectSize <= max), message);
	}
	
	/**
	 * Avalia se o valor atende o mínimo permitido.
	 * @param objectSize
	 * @param min
	 * @param message
	 * @return
	 */
	public static Expression min(Integer objectSize, Integer min, Message message) {
		return createExpression(!(objectSize >= min), message);
	}
	
	/**
	 * Avalia se o valor atende o máximo permitido.
	 * @param objectSize
	 * @param max
	 * @param message
	 * @return
	 */
	public static Expression max(Integer objectSize, Integer max, Message message) {
		return createExpression(!(objectSize <= max), message);
	}
	
	/**
	 * Avalia se o pattern regex encontrou um resultado igual ao input. 
	 * @param regex
	 * @param input
	 * @return
	 */
	private static boolean encontrouTodasAsOcorrencias(final String regex, final String input) {
		StringBuilder sbOcorrencias = new StringBuilder();
		Matcher m = Pattern.compile(regex).matcher(input);
		
		while (m.find()) {
			sbOcorrencias.append(m.group());
		}
		
		return input.equals(sbOcorrencias.toString());  
	}

}
