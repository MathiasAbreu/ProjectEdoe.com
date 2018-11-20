package br.com.lp2.edoe.facade;

import br.com.lp2.edoe.controller.ControllerUsuario;
import easyaccept.EasyAccept;

/**
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 * @author Klaywert
 * @author Caio
 * 
 */
public class EdoeFacade {

	private ControllerUsuario controleUser;
	
	public EdoeFacade() {
		
		controleUser = new ControllerUsuario();
		
	}
	public String adicionaDoador(String id,String nome,String email,String celular,String classe) {
		
		return controleUser.adicionarDoador(id,nome,email,celular,classe);
		
	}
	
	public String pesquisaUsuarioPorId(String id) {
		
		return controleUser.buscarUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) {
		
		return controleUser.buscarUsuarioPorNome(nome);
		
	}
	
	public void lerReceptores(String caminho) {
		
		controleUser.lerReceptores(caminho);
		
	}
	
	public void atualizaUsuario(String id,String nome,String email,String celular) {
		
		controleUser.atualizaUsuario(id,nome,email,celular);
		
	}
	
	public void removeUsuario(String id) {
		
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
