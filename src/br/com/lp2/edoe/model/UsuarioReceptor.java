package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 * 
 */
public class UsuarioReceptor extends Usuario implements Receptor,Doador {
	
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public UsuarioReceptor(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao,"receptor");

	}

	@Override
	public void receberDoacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RealizaDoacao() {
		// TODO Auto-generated method stub
		
	}

}
