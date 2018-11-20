package br.com.lp2.edoe.model;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * 
 * 
 */
public class UsuarioDoador extends Usuario implements Doador {

	private final String status = "Doador";
	
	/**
	 * @param nome
	 * @param email
	 * @param celular
	 * @param classe
	 * @param identificacao
	 */
	public UsuarioDoador(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao);

	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	@Override
	public void RealizaDoacao() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		
		return String.format("%s/%s,%s,%s,status:%s",getNome(),getIdentificacao(),getEmail(),getCelular(),status);
	}

}
