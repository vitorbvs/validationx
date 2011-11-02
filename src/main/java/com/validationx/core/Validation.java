package com.validationx.core;

import java.util.ArrayList;
import java.util.List;

import com.validationx.Expression;
import com.validationx.Message;

/**
 * Encapsula o que � comum ao ato de validar.
 * 
 * @author Ellison
 *
 */
public abstract class Validation {
	
	private final List<Message> messages = new ArrayList<Message>();;

	/**
	 * Implementa��o default da express�o que avalia se � necess�rio ou n�o
	 * adicionar uma mensagem de valida��o.
	 * 
	 * @param expression - se for true, � adicionada uma mensagem de erro. Se for false, n�o faz nada. 
	 * @param mensagem - A mensagem por si mesma.
	 * @param placeHolders PlaceHolders que a mensagem possui.
	 * @return
	 */
	protected Validation evaluate(final Expression expression) {		
		if (expression.isInvalidExpression())
			addMessage(expression.getMessage());
		
		return this;
	}
	
	/**
	 * @return se {@link messages} n�o for vazio,
	 * 		ent�o retorna <b>true</b>, caso contr�rio, retorna <b>false</b>
	 */
	protected boolean hasErrors() {
		return !messages.isEmpty();
	}
	
	/**
	 * Adiciona uma mensagem � lista de mensagens.
	 * @param message
	 */
	private void addMessage(final Message message) {			
		messages.add(message);
	}

	/**
	 * Retorna a lista completa de mensagens.
	 * @return
	 */
	public List<Message> getMessages() {
		return messages;
	}
	
	
}
