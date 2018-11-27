package br.com.lp2.edoe.model;

/**
 * Classe que representa um {@link Usuario} do tipo {@link Receptor}.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class UsuarioReceptor extends Usuario {
	
	/**
	 * Construtor reponsavel por instanciar um novo Usuario do tipo {@link Receptor}, ele recebe todos os parametros necessarios para preencher 
	 * os atributos basicos de um Usuario.
	 * 
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @param classe classe do usuario
	 * @param identificacao numero de identificacao do usuario
	 * 
	 */
	public UsuarioReceptor(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao);

	}

	/**
	 * Metodo que retorna uma representacao textual de um {@link UsuarioReceptor}.
	 * 
	 * @return Retorna uma representacao textual do usuario.
	 */
	@Override
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: receptor",getNome(),getIdentificacao(),getEmail(),getCelular());

	}

	/**
	 * Metodo que retorna uma representacao afirmando que o usuario eh do tipo receptor.
	 * 
	 * @return Retorna a String 'Receptor'.
	 */
	@Override
	public String getStatus() {
		return "Receptor";
	}

}
