package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 * 
 */
public class UsuarioReceptor extends Usuario implements Receptor {

	private final String status = "Receptor";
	
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public UsuarioReceptor(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao);

	}

	@Override
	public void receberDoacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		
		return String.format("%s/%s,%s,%s,status:%s",getNome(),getIdentificacao(),getEmail(),getCelular(),status);

	}

}
