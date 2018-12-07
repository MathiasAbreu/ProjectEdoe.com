package br.com.lp2.edoe.exceptions;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class NegativeIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeIdException() {
		super("Entrada invalida: id do item nao pode ser negativo.");
	}
}
