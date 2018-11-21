package br.com.lp2.edoe.model;

/**
 * Classe que representa um {@link Usuario} do tipo {@link Doador}.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class UsuarioDoador extends Usuario implements Doador {
	
	/**
	 * Construtor reponsável por instanciar um novo Usuario do tipo {@link Doador}, ele recebe todos os parâmetros necessários para preencher 
	 * os atributos básicos de um Usuario.
	 * 
	 * @param nome nome do usuário
	 * @param email email do usuário
	 * @param celular celular do usuário
	 * @param classe classe do usuário
	 * @param identificacao núemro de identificação do usuário
	 * 
	 */
	public UsuarioDoador(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao,"doador");

	}

	
	@Override
	public void RealizaDoacao() {
		// TODO Auto-generated method stub

	}

}
