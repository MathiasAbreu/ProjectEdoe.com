/**
 * 
 */
package br.com.lp2.edoe.model;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class InvalidArgumentException extends Exception {
	
	public InvalidArgumentException(String atributo) {
		
		super("Entrada invalida: " + atributo + " do usuario nao pode ser vazio ou nulo.");
	}
}
