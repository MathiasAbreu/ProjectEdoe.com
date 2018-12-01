package br.com.lp2.edoe.exceptions;

/**
 * Classe que representa um excecao que eh lancada caso algum metodo receba um parametro invalido.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class InvalidArgumentException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que gera um excecao do tipo {@link InvalidArgumentException} recebendo como parametro o nome do atributo que gerou esse erro.
	 * 
	 * @param atributo nome do atributo que gerou esse erro.
	 * 
	 */
	public InvalidArgumentException(String atributo) {
		
		super(atributo.equals("classe") || atributo.equals("descricao") ? "Entrada invalida: " + atributo + " nao pode ser vazia ou nula." : "Entrada invalida: " + atributo + " nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Metodo que gera um excecao do tipo {@link InvalidArgumentException} recebendo como parametro o nome do atributo que gerou esse erro, como tambem algum complemento que deva ser colocado na mensagem de erro.
	 * 
	 * @param atributo nome do atributo que gerou esse erro.
	 * @param adicional complemento que tambem deva ser colocado na mensagem de erro
	 * 
	 */
	public InvalidArgumentException(String atributo,String adicional) {
		
		super(atributo.equals("classe")  || atributo.equals("descricao") ? "Entrada invalida: " + atributo + " " + adicional + " " + "nao pode ser vazio ou nulo." : "Entrada invalida: " + atributo + " " + adicional + " " + "nao pode ser vazio ou nulo.");
	}
	
}
