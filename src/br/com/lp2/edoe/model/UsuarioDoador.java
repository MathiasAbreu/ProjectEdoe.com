package br.com.lp2.edoe.model;

/**
 * Classe que representa um {@link Usuario} do tipo {@link Doador}.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class UsuarioDoador extends Usuario {
	
	/**
	 * Construtor reponsavel por instanciar um novo Usuario do tipo {@link Doador}, ele recebe todos os parametros necessarios para preencher 
	 * os atributos basicos de um Usuario.
	 * 
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @param classe classe do usuario
	 * @param identificacao nuemro de identificacao do usuario
	 * 
	 */
	public UsuarioDoador(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao);

	}

	/**
	 * Metodo que retorna uma representacao textual do {@link UsuarioDoador}.
	 * 
	 * @return Retorna uma representacao textual do usuario.
	 */
	@Override
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: doador",getNome(),getIdentificacao(),getEmail(),getCelular());
	}

	/**
	 * Metodo que retorna uma representacao afirmando que o usuario eh do tipo doador.
	 * 
	 * @return Retorna a String 'doador'.
	 */
	@Override
	public String getStatus() {
		return "doador";
	}

	
	
}
