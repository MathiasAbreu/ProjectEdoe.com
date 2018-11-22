package br.com.lp2.edoe.facade;

import br.com.lp2.edoe.controller.ControllerUsuario;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import easyaccept.EasyAccept;

/**
 * Classe de Fachada do sistema Edoe.com.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class EdoeFacade {

	private ControllerUsuario controleUser;
	
	public EdoeFacade() {
		
		controleUser = new ControllerUsuario();
		
	}
	public String adicionaDoador(String id,String nome,String email,String celular,String classe) throws InvalidArgumentException {
		
		return controleUser.adicionarDoador(id,nome,email,celular,classe);
		
	}
	
	public void adicionaDescritor(String descricao) throws InvalidArgumentException {
		
		controleUser.adicionaDescritor(descricao);
	}
	
	public String adicionaItemParaDoacao(String idDoador,String descricaoItem,int quantidade,String tags) throws InvalidArgumentException {
		
		return controleUser.adicionaItemParaDoacao(idDoador,descricaoItem,quantidade,tags);
		
	}
	public String pesquisaUsuarioPorId(String id) {
		
		return controleUser.buscarUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) throws InvalidArgumentException {
		
		return controleUser.buscarUsuarioPorNome(nome);
		
	}
	
	public void lerReceptores(String caminho) {
		
		controleUser.lerReceptores(caminho);
		
	}
	
	public void atualizaReceptores(String caminho) {
		
		controleUser.atualizarReceptores(caminho);
		
	}
	
	public String atualizaUsuario(String id,String nome,String email,String celular) throws InvalidArgumentException {
		
		return controleUser.atualizaUsuario(id,nome,email,celular);
		
	}
	
	public void removeUsuario(String id) throws InvalidArgumentException {
		
		controleUser.removeUsuario(id);
		
	}
	
	public static void main(String[] args) {
		
		args = new String[] {"br.com.lp2.edoe.facade.EdoeFacade",
				 "src/br/com/lp2/edoe/easyAccept/use_case_1.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_2.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_3.txt"};
		
		EasyAccept.main(args);
		
	}
}
