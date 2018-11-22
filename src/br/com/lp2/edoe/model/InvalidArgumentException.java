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
		
		super(atributo.equals("classe") || atributo.equals("descricao") ? "Entrada invalida: " + atributo + " nao pode ser vazia ou nula." : "Entrada invalida: " + atributo + " nao pode ser vazio ou nulo.");
	}
	
	public InvalidArgumentException(String atributo,String adicional) {
		
		super(atributo.equals("classe")  || atributo.equals("descricao") ? "Entrada invalida: " + atributo + " " + adicional + " " + "nao pode ser vazio ou nulo." : "Entrada invalida: " + atributo + " " + adicional + " " + "nao pode ser vazio ou nulo.");
	}
	
}
