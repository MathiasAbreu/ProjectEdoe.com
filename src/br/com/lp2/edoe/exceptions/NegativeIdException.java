package br.com.lp2.edoe.exceptions;

/**
 * Classe que representa um excecao que eh lancada caso algum metodo receba como parametro um id negativo.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class NegativeIdException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que gera a excecao causada pelo id negativo.
	 * 
	 */
	public NegativeIdException() {
		super("Entrada invalida: id do item nao pode ser negativo.");
	}
}
