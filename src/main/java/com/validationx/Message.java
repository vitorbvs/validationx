package com.validationx;

/**
 * Mensagem, composta por uma mensagem e placeholders.
 * Esta classe "sabe" como criar um objeto mensagem.
 * N�o � poss�vel instanci�-la.
 *  
 * @author Ellison
 *
 */
public class Message {
	
	String mensagem;
	String[] placeHolders;
	
	/**
	 * Construtor default de Message 
	 * @param mensagem
	 * @param placeHolders
	 */
	protected Message(String mensagem, String... placeHolders) {
		this.mensagem = mensagem;
		this.placeHolders = placeHolders;
	}
	
	/**
	 * Obt�m a mensagem informada.
	 * @return String
	 */
	public String getMensagem() {
		return mensagem;
	}
	
	/**
	 * Obt�m os placeHolders informados.
	 * @return String[]
	 */
	public String[] getPlaceHolders() {
		return placeHolders;
	}
	
	/**
	 * Cria e retorna uma nova inst�ncia de mensagem para ser utilizada.
	 * 
	 * @param mensagem Mensagem que ser� utilizada
	 * @param placeHolders PlaceHolders da mensagem utilizada
	 * @return
	 */
	public static Message createMessage(String mensagem, String... placeHolders) {
		return new Message(mensagem, placeHolders);
	}

}
