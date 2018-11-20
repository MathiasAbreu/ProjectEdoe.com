package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 * 
 */
public class UsuarioDoador extends Usuario implements Doador {
	
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public UsuarioDoador(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao,"doador");

	}

	/**
	 * @return the status
	 */

	@Override
	public void RealizaDoacao() {
		// TODO Auto-generated method stub

	}

}
