package br.com.lp2.edoe.exceptions;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class InvalidUserException extends Exception {

	public InvalidUserException(String usuario) {
		
		super("Usuario nao encontrado: " + usuario + ".");
	}
	
	public InvalidUserException(String usuario,String complemento) {
		
		super("Usuario " + complemento + ": " + usuario + ".");
	}
}
