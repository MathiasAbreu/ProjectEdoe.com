package br.com.lp2.edoe.exceptions;

/**
 * Classe que representa um excecao que eh lancada caso haja algum erro na escrita em determinado arquivo.
 * 
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 */
public class FileWriteErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que gera a excecao, recebendo como parametro, o nome do arquivo que gerou o erro.
	 * 
	 * @param arquivo Nome do arquivo.
	 * 
	 */
	public FileWriteErrorException(String arquivo) {
		super("Erro ao escrever no arquivo: " + arquivo);
	}
}
