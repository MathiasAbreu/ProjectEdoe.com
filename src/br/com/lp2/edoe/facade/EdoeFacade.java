package br.com.lp2.edoe.facade;


import br.com.lp2.edoe.controller.ControllerEdoe;
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
	
	public void adicionaDescritor(String descricao) throws Exception { 
		
		controle.adicionaDescritor(descricao);
	}
	
	public String adicionaItemParaDoacao(String idDoador,String descricaoItem,int quantidade,String tags) throws Exception {
		
		return controle.adicionaItem(idDoador,descricaoItem,quantidade,tags);
		
	}
	public String pesquisaUsuarioPorId(String id) throws Exception {
		
		return controle.buscarUsuarioPorId(id);
	}
	
	public String pesquisaUsuarioPorNome(String nome) throws Exception {
		
		return controle.buscarUsuarioPorNome(nome);
		
	}
	
	public void lerReceptores(String caminho) throws Exception {
		
		controle.lerReceptores(caminho);
		
	}
	
	public void atualizaReceptores(String caminho) throws Exception {
		
		controle.atualizarReceptores(caminho);
		
	}
	
	public String atualizaUsuario(String id,String nome,String email,String celular) throws Exception {
		
		return controle.atualizaUsuario(id,nome,email,celular);
		
	}
	
	public void removeUsuario(String id) throws Exception {
		
		controle.removeUsuario(id);
		
	}
	
	public String atualizaItemParaDoacao(String id,String idDoador,int quantidade,String tags) throws Exception {
		
		return controle.atualizaItem(id, idDoador,quantidade,tags);
		
	}
	
	public void removeItemParaDoacao(String id, String idDoador) throws Exception {
		
		controle.removeItem(id, idDoador);
		
	}
	
	public String exibeItem(String id,String idDoador) throws Exception {
		
		return controle.exibeItem(id, idDoador);
	}
	
	public String listaDescritorDeItensParaDoacao() throws Exception {
		
		return controle.listaDescritorDeItens();
	}
	
	public String listaItensParaDoacao() throws Exception {
		
		return controle.listaItens("doador");
		
	}
	
	public String pesquisaItemParaDoacaoPorDescricao(String desc) throws Exception {
		
		return controle.pesquisaItemPorDescricao(desc);
		
	}
	
	public String adicionaItemNecessario(String idReceptor,String descricaoItem,int quantidade,String tags) throws Exception {
		
		return controle.adicionaItem(idReceptor, descricaoItem, quantidade, tags);
	}
	
	public String listaItensNecessarios() throws Exception {
		
		return controle.listaItens("Receptor");
	}
	
	public String atualizaItemNecessario(String idReceptor,String idItem,int novaQuantidade,String novasTags) throws Exception {
		
		return controle.atualizaItem(idItem, idReceptor, novaQuantidade, novasTags);
	}
	
	public void removeItemNecessario(String idReceptor, String idItem) throws Exception {
		
		controle.removeItem(idItem, idReceptor);
	}
	
	public String match(String idReceptor,String idItemNecessario) throws Exception {
		
		return controle.match(idReceptor,idItemNecessario);
	}
		
	public String realizaDoacao(String idItemNec, String idItemDoado, String data) throws Exception {
		
		return controle.realizaDoacao(idItemNec, idItemDoado, data);
	}
	
	public String listaDoacoes() {
		
		return controle.listaDoacoes();
	}
	
	public void iniciaSistema() throws Exception {
		
		controle.iniciaSistema();
	}
	
	public void finalizaSistema() throws Exception {
		
		controle.finalizaSistema();
		controle = new ControllerEdoe();
	}

	public static void main(String[] args) {
		
		args = new String[] {"br.com.lp2.edoe.facade.EdoeFacade",
				 "src/br/com/lp2/edoe/easyAccept/use_case_1.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_2.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_3.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_4.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_5.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_6.txt",
				 "src/br/com/lp2/edoe/easyAccept/use_case_7.txt"};
		
		EasyAccept.main(args);
		
	}
	
}
