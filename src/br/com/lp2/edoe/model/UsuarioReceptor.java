package br.com.lp2.edoe.model;

/**
 * Classe que representa um {@link Usuario} do tipo {@link Receptor}.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class UsuarioReceptor extends Usuario implements Receptor,Doador {
	
	/**
	 * Construtor reponsável por instanciar um novo Usuario do tipo {@link Receptor}, ele recebe todos os parâmetros necessários para preencher 
	 * os atributos básicos de um Usuario.
	 * 
	 * @param nome nome do usuário
	 * @param email email do usuário
	 * @param celular celular do usuário
	 * @param classe classe do usuário
	 * @param identificacao número de identificação do usuário
	 * 
	 */
	public UsuarioReceptor(String nome, String email, String celular, String classe, String identificacao) {
		
		super(nome, email, celular, classe, identificacao);

	}

	@Override
	public void receberDoacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RealizaDoacao() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.lp2.edoe.model.Usuario#toString()
	 */
	@Override
	public String toString() {
		
		return String.format("%s/%s, %s, %s, status: receptor",getNome(),formatarId(),getEmail(),getCelular());

	}

}
