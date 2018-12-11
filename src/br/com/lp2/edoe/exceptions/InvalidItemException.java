package br.com.lp2.edoe.exceptions;

/**
 * Classe que representa um excecao que eh lancada caso algum item buscado nao se encontre no sistema.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class InvalidItemException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que gera um excecao do tipo {@link InvalidItemException} recebendo como parametro o id do item que gerou esse erro. 
	 * O erro eh gerado caso o item nao seja encontrado no sistema.
	 * 
	 * @param item (id) que gerou esse erro.
	 * 
	 */
	public InvalidItemException(String item) {
		
		super("Item nao encontrado: " + item + ".");
	}
	
	/**
	 * Metodo que gera uma excecao do tipo {@link InvalidItemException} caso o usuario nao possua itens cadastrados.
	 * 
	 */
	public InvalidItemException() {
		
		super("O Usuario nao possui itens cadastrados.");
	}
}
