/**
 * 
 */
package br.com.lp2.edoe.exceptions;

/**
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class FileReadErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public FileReadErrorException(String arquivo) {
		super("Erro ao ler arquivo: " + arquivo);
	}
}
