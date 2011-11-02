package com.validationx;


/**
 * Um Expression é o objeto que possui as informações necessárias
 * para ser validado.
 * 
 * @author Ellison
 */
public final class Expression {

	private boolean invalidExpression;
	private Message message;
	
	/**
	 * Construtor 
	 * @param validExpression
	 * @param message
	 * @param placeHolders
	 */
	private Expression(boolean invalidExpression, Message message) {
		this.invalidExpression = invalidExpression;
		this.message = message;
	}
	
	/**
	 * Informa se uma expressão é inválida.
	 * Sempre será true quando a expressão for inválida.
	 * @return
	 */
	public boolean isInvalidExpression() {
		return invalidExpression;
	}
	
	/**
	 * Retorna o objeto mensagem. 
	 * @return
	 */
	public Message getMessage() {
		return message;
	}
	
	/**
	 * Cria uma nova instância de Expression;
	 * @param condition
	 * @return
	 */
	public static Expression createExpression(boolean condition, Message message) {
		return new Expression(condition, message);
	}

	
}