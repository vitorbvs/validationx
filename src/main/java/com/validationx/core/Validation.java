package com.validationx.core;

import java.util.ArrayList;
import java.util.List;

import com.validationx.Expression;
import com.validationx.Message;

/**
 * Encapsula o que é comum ao ato de validar.
 * 
 * @author Ellison
 *
 */
public abstract class Validation {
	
	private final List<Message> messages = new ArrayList<Message>();;

	/**
	 * Implementação default da expressão que avalia se é necessário ou não
	 * adicionar uma mensagem de validação.
	 * 
	 * @param expression - se for true, é adicionada uma mensagem de erro. Se for false, não faz nada. 
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
	 * @return se {@link messages} não for vazio,
	 * 		então retorna <b>true</b>, caso contrário, retorna <b>false</b>
	 */
	protected boolean hasErrors() {
		return !messages.isEmpty();
	}
	
	/**
	 * Adiciona uma mensagem à lista de mensagens.
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
