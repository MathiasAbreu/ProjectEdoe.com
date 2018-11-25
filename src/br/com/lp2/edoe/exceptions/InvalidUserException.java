package br.com.lp2.edoe.exceptions;

/**
 * Classe que representa um excecao que eh lancada caso algum metodo receba um parametro invalido.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class InvalidUserException extends Exception {

	/**
	 * Metodo que gera um excecao do tipo {@link InvalidUserException} recebendo como parametro o (id ou nome) do usuario que gerou esse erro. 
	 * O erro eh gerado caso haja algum problema com o usuario buscado.
	 * 
	 * @param usuario (id ou nome) do usuario que gerou esse erro.
	 * 
	 */
	public InvalidUserException(String usuario) {
		
		super("Usuario nao encontrado: " + usuario + ".");
	}
	
	/**
	 * Metodo que gera um excecao do tipo {@link InvalidUserException} recebendo como parametro o (id ou nome) do usuario que gerou esse erro, 
	 * como também algum complemento adicional que precise participar da mensagem de erro. 
	 * O erro eh gerado caso haja algum problema com o usuario buscado.
	 * 
	 * @param usuario (id ou nome) do usuario que gerou esse erro.
	 * @param complemento mensagem de complemento que deve fazer parte da mensagem de erro.
	 * 
	 */
	public InvalidUserException(String usuario,String complemento) {
		
		super("Usuario " + complemento + ": " + usuario + ".");
	}
}
