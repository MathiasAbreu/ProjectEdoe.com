package br.com.lp2.edoe.facade;

import br.com.lp2.edoe.controller.ControllerEdoe;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidUserException;
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

	private ControllerEdoe controle;
	
	public EdoeFacade() {
		
		controle = new ControllerEdoe();
		
	}
	public String adicionaDoador(String id,String nome,String email,String celular,String classe) throws Exception {
		
		return controle.adicionarDoador(id,nome,email,celular,classe); 
		
	}
	
	public void adicionaDescritor(String descricao) throws InvalidArgumentException { 
		
		controle.adicionaDescritor(descricao);
	}
	
	public String adicionaItemParaDoacao(String idDoador,String descricaoItem,int quantidade,String tags) throws Exception {
		
		return controle.adicionaItemParaDoacao(idDoador,descricaoItem,quantidade,tags);
		
	}
	public String pesquisaUsuarioPorId(String id) throws Exception {
		
		return controle.buscarUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) throws Exception {
		
		return controle.buscarUsuarioPorNome(nome);
		
	}
	
	public void lerReceptores(String caminho) {
		
		controle.lerReceptores(caminho);
		
	}
	
	public void atualizaReceptores(String caminho) {
		
		controle.atualizarReceptores(caminho);
		
	}
	
	public String atualizaUsuario(String id,String nome,String email,String celular) throws Exception {
		
		return controle.atualizaUsuario(id,nome,email,celular);
		
	}
	
	public void removeUsuario(String id) throws Exception {
		
		controle.removeUsuario(id);
		
	}
	
	public String atualizaItemParaDoacao(String id,String idDoador,int quantidade,String tags) throws Exception {
		
		return controle.atualizaItemParaDoacao(id, idDoador,quantidade,tags);
		
	}
	
	public void removeItemParaDoacao(String id, String idDoador) throws Exception {
		
		controle.removeItemParaDoacao(id, idDoador);
		
	}
	
	public String exibeItem(String id,String idDoador) throws Exception {
		
		return controle.exibeItem(id, idDoador);
	}
	
	public String listaDescritorDeItensParaDoacao() {
		
		return controle.listaDescritorDeItensParaDoacao();
	}
	
	public static void main(String[] args) {
		
		args = new String[] {"br.com.lp2.edoe.facade.EdoeFacade",
				 "src/br/com/lp2/edoe/easyAccept/use_case_1.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_2.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_3.txt"};
		
		EasyAccept.main(args);
		
	}
	
}
