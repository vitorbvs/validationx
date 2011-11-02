package com.validationx;


/**
 * Um Expression � o objeto que possui as informa��es necess�rias
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
	 * Informa se uma express�o � inv�lida.
	 * Sempre ser� true quando a express�o for inv�lida.
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
	 * Cria uma nova inst�ncia de Expression;
	 * @param condition
	 * @return
	 */
	public static Expression createExpression(boolean condition, Message message) {
		return new Expression(condition, message);
	}

	
}