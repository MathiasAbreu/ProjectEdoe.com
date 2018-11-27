package br.com.lp2.edoe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import br.com.lp2.edoe.comparators.ComparadorItemPorDescricao;
import br.com.lp2.edoe.comparators.ComparadorItemPorId;
import br.com.lp2.edoe.comparators.ComparadorItemPorQuantidade;
import br.com.lp2.edoe.dao.ReceptoresDao;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidUserException;
import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Usuario;
import br.com.lp2.edoe.model.UsuarioDoador;
import br.com.lp2.edoe.model.UsuarioReceptor;

/**
 * Classe responsavel pelo controle, manipulacao e armazenamento de Usuarios e suas especializacoes.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ControllerEdoe {
	
	private int indiceId;
	
	private LinkedHashMap<String,Usuario> usuarios;
	private ReceptoresDao arquivoReceptores;
		
	private HashSet<String> descritores;
		
	/**
	 * Construtor responsavel pela construcao da instancia da classe, assim como da colecao de armazenamento dos 
	 * usuarios e o acesso aos arquivos de armazenamento.
	 * 
	 */
	public ControllerEdoe() {
				
		indiceId = 0;
		
		usuarios = new LinkedHashMap<>();
		arquivoReceptores = new ReceptoresDao();
		
		descritores = new HashSet<>();
		
	}
	
	/**
	 * Metodo responsavel pelo cadastro de Usuarios do tipo {@link UsuarioDoador} no sistema, ele recebe todos os parametros 
	 * necessarios para a criacao dos mesmos. O processo comeca verificando a validade dos dados recebidos, seguido pela verificao 
	 * da existencia de tal usuario no sistema e por fim armazena o mesmo na colecao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular de contato do usuario
	 * @param classe tipo de usuario
	 * 
	 * @return Retorna a identificao do Usuario recem cadastrado.

	 * @throws InvalidUserException Excecao gerada caso o usuario ja se encontre cadastrado no sistema.
	 * @throws InvalidArgumentException Essa excecao eh gerada caso seja passada uma classe de usuario que nao conste no sistema.
	 * 
	 */
	public String adicionarDoador(String id, String nome, String email, String celular, String classe) throws Exception {
		
		if(id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		
		if(usuarios.containsKey(id)) {
			
			throw new InvalidUserException(id,"ja existente");
		}
		else {
			
			if(nome == null || nome.trim().isEmpty())
				throw new InvalidArgumentException("nome");
			if(email == null || email.trim().isEmpty())
				throw new InvalidArgumentException("email");
			if(celular == null || celular.trim().isEmpty())
				throw new InvalidArgumentException("celular");
			if(classe == null || classe.trim().isEmpty())
				throw new InvalidArgumentException("classe");
			
			if(classe.equals("PESSOA_FISICA") || classe.equals("IGREJA") || classe.equals("ORGAO_PUBLICO_ESTADUAL") || classe.equals("ORGAO_PUBLICO_FEDERAL") || classe.equals("ONG") || classe.equals("ASSOCIACAO") || classe.equals("SOCIEDADE")) {
				
				usuarios.put(id, new UsuarioDoador(nome, email, celular, classe, id));
				return id;
			}
			
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
	}
	
	private void adicionarReceptores(ArrayList<String> receptores) {
		
		for (String receptor : receptores) {
			
			String[] dados = receptor.split(",");
			usuarios.put(dados[0],new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
		}
	}

	/**
	 * Metodo que busca pela identificacao se determinado Usuario esta cadastrado no sistema. O metodo verifica se o numero da 
	 * identificao eh valido antes de realizar a busca em si.
	 * 
	 * @param id identificacao do usuario
	 * 
	 * @return Retorna a representacao textual do {@link Usuario}.
	 *  
	 * @throws InvalidArgumentException Excecao gerada caso o numero de identificacao recebido seja invalido.
	 * @throws InvalidUserException Essa excecao eh gerada caso o usuario nao seja encontrado no sistema.
	 * 
	 */
	public String buscarUsuarioPorId(String id) throws Exception {
		
		if(id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		
		if(usuarios.containsKey(id)) {
			
			for (Usuario usuario : usuarios.values()) {
				
				if(usuario.getIdentificacao().equals(id))
					return usuario.toString();
			}
		}
		
		throw new InvalidUserException(id);
	}

	/**
	 * Metodo que busca pelo nome se existem determinados usuarios cadastrados no sistema. O metodo verifica se o nome do 
	 * usuario eh valido antes de realizar a busca em si.
	 * 
	 * @param nome nome do(s) usuario(s)
	 * 
	 * @return Retorna uma representacao com todos os possiveis usuarios encontrados.
	 * 
	 * @throws InvalidArgumentException Essa excecao eh gerada caso o nome informado seja considerado invalido.
	 * @throws InvalidUserException Excecao gerada caso nao exista nenhum usuario com esse nome.
	 * 
	 */
	public String buscarUsuarioPorNome(String nome) throws Exception {
		
		if(nome == null || nome.trim().isEmpty())
			throw new InvalidArgumentException("nome");
		
		ArrayList<Usuario> usuariosPorNome = new ArrayList<>();
		String retorno = "";
		
		for(Usuario usuario : usuarios.values()) {
			
			if(usuario.getNome().equals(nome))
				usuariosPorNome.add(usuario);
		}
		
		if(usuariosPorNome.size() == 0)
			throw new InvalidUserException(nome);
		
		retorno += usuariosPorNome.get(0).toString();
		
		for (int i = 1;i < usuariosPorNome.size(); i++) {
			retorno += " | " + usuariosPorNome.get(i).toString();
		}
		return retorno;
	}

	/**
	 * Metodo que le receptores a serem cadastrados no sistema a partir de arquivos externos que sejam fornecidos ao mesmo.
	 * 
	 * @param caminho caminho do arquivo a ser lido.
	 * 
	 * @throws IOException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public void lerReceptores(String caminho) throws IOException {
		
		ArrayList<String> receptores = arquivoReceptores.lerReceptores(caminho);
		adicionarReceptores(receptores);
		
	}

	
	/**
	 * Metodo que atualiza os dados de um usuario do sistema. Caso um dos parametros seja nulo
	 * ou vazio, o dado correspondente nao eh editado. O metodo verifica se o numero da 
	 * identificacao eh valido antes de realizar a remocao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular de contato do usuario
	 * 
	 * @return Retorna a nova representacao textual do {@link Usuario}.
	 * 
	 * @throws InvalidArgumentException Essa excecao eh gerada caso o id informado seja nulo ou invalido.
	 * @throws InvalidUserException Excecao gerada caso o usuario nao esteja cadastrado no sistema.
	 * 
	 */
	public String atualizaUsuario(String id, String nome, String email, String celular) throws Exception {
		if (id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");

		if (!usuarios.containsKey(id)) {
			throw new InvalidUserException(id);
		}
		
		if(nome != null && !(nome.trim().isEmpty()))
			usuarios.get(id).setNome(nome);
		if(email != null && !(email.trim().isEmpty()))
			usuarios.get(id).setEmail(email);
		if(celular != null && !(celular.trim().isEmpty()))
			usuarios.get(id).setCelular(celular);
		
		return usuarios.get(id).toString();
	}

	/**
	 * Metodo que remove um usuario do sistema. O metodo verifica se o numero da 
	 * identificacao eh valido antes de realizar a remocao.
	 * 
	 * @param id identificacao do usuario. CPF para pessoa fisica, CNPJ para demais.
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso o id do usuario seja considerado invalido ou nulo.
	 * @throws InvalidUserException Essa excecao eh gerada caso o usuario nao seja encontrado no sistema.
	 * 
	 */
	public void removeUsuario(String id) throws Exception {
		if (id == null || id.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		
		if (!usuarios.containsKey(id)) {
			throw new InvalidUserException(id);
		}
		
		usuarios.remove(id);
	}

	/**
	 * Metodo que atualiza os usuarios receptores cadastrados no sistema, modificando-os atraves da leitura de outro arquivo 
	 * que contem os dados atualizados dos mesmos.
	 * 
	 * @param caminho caminho do arquivo que contem os dados atualizados.
	 * 
	 * @throws IOException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public void atualizarReceptores(String caminho) throws IOException {
		
		ArrayList<String> receptoresParaAtualizar = arquivoReceptores.lerReceptores(caminho);
		
		for (String receptor : receptoresParaAtualizar) {
			
			String[] dados = receptor.split(",");
			
			for (String key : usuarios.keySet()) {
				
				if(usuarios.get(key).getIdentificacao().equals(dados[0])) {
					
					usuarios.remove(key);
					usuarios.put(key,new UsuarioReceptor(dados[1],dados[2],dados[3],dados[4],dados[0]));
				}
			}
		}
		
	}

	/**
	 * Metodo que adiciona descritores de itens no sistema, ele recebe como parametro os proprios descritores, 
	 * verifica se os mesmos sao validos e nao estao cadastrados no sistema ainda, e por fim adiciona-os na colecao 
	 * que os armazena.
	 * 
	 * @param descricao descritor do item
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso a descricao informada seja considerada invalida.
	 * @throws RuntimeException Essa excecao eh gerada caso o descritor ja se encontre cadastrado.
	 * 
	 */
	public void adicionaDescritor(String descricao) throws InvalidArgumentException {
		
		if(descricao == null || descricao.trim().isEmpty())
			throw new InvalidArgumentException("descricao");
		
		if(descritores.contains(descricao.toLowerCase().replaceAll("\\s"," ")))
			throw new RuntimeException("Descritor de Item ja existente: " + descricao.toLowerCase().replaceAll("\\s"," ") + ".");
		
		descritores.add(descricao.toLowerCase().replaceAll("\\s"," "));
	}

	/**
	 * Metodo responsavel pelo cadastro de novos itens disponiveis para doacao no sistema, ele recebe como parametro os dados do novo item, assim como 
	 * o usuario que esta disponibilizando o mesmo, verifica se todos os dados sao validos e por fim adiciona o novo item disponivel.
	 * 
	 * @param idDoador id do doador do item
	 * @param descricaoItem descricao do item
	 * @param quantidade quantidade disponivel do item
	 * @param tags tags que servem para incluir mais informacoes acerca dos itens
	 * 
	 * @return Retorna o id unico do item recem criado
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso algum dos dados informados sejam nulos ou invalidos.
	 * @throws InvalidUserException Essa excecao eh gerada caso o usuario que disponibilizou o item nao seja encontrado.
	 * 
	 */
	public String adicionaItemParaDoacao(String idDoador, String descricaoItem, int quantidade, String tags) throws Exception {
		
		if(idDoador == null || idDoador.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");
		if(descricaoItem == null || descricaoItem.trim().isEmpty())
			throw new InvalidArgumentException("descricao");
		if(quantidade <= 0)
			throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");
		
		if(descritores.contains(descricaoItem.toLowerCase().replaceAll("\\s"," "))) { 
			
		}
		else
			adicionaDescritor(descricaoItem.toLowerCase().replaceAll("\\s"," "));
		
		if(usuarios.containsKey(idDoador)) {
			
			String[] tagsArray = tags.split(",");
			indiceId ++;
			return usuarios.get(idDoador).adicionaItem(indiceId,descricaoItem.toLowerCase().replaceAll("\\s"," "),quantidade,tagsArray);
		}
		
		throw new InvalidUserException(idDoador);
			}

	/**
	 * Metodo que faz a busca de um item no sistema e retorna a representacao textual do mesmo.
	 * 
	 * @param idItem id do item
	 * @param idDoador id do doador do item
	 * 
	 * @return Retorna a representacao textual do item, se o mesmo existir.
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso algum dos dados informados sejam nulos ou invalidos.
	 * @throws InvalidUserException Essa excecao eh gerada caso o usuario que disponibilizou o item nao seja encontrado.
	 * 
	 */
	public String exibeItem(String idItem, String idDoador) throws Exception {
		if (idItem == null || idItem.trim().isEmpty())
			throw new InvalidArgumentException("id","do item");
		
		if (idDoador == null || idDoador.trim().isEmpty())
			throw new InvalidArgumentException("id","do usuario");

		if (!usuarios.containsKey(idDoador)) {
			throw new InvalidUserException(idDoador);
		}
		
		return usuarios.get(idDoador).exibeItem(idItem);
	}
	
	/**
	 * Metodo que atualiza um determinado item cadastrado no sistema. Podem ser alterados: quantidade do item ou as tags relacionadas ao item.
	 * Caso o parametro quantidade ou tags for null, e considerado que o parametro nao necessita de alteracao, prosseguindo a execucao normal do programa.
	 * Retorna o toString do item ja atualizado, como confirmacao da alteracao.
	 * 
	 * @param id identificador do item
	 * @param idDoador identificador do doador que possui o item a ser atualizado
	 * @param quantidade quantidade atualizada do item em questao
	 * @param tags novas tags que serao relacionadas ao item
	 * 
	 * @return representacao textual do item atualizado
	 * 
	 * @throws InvalidArgumentException excecao em caso do id (usuario ou item) ser nulo ou vazio
	 * @throws InvalidUserException excecao em caso do id (usuario ou item) nao for cadastrado no sistema
	 */
	public String atualizaItemParaDoacao(String id, String idDoador, int quantidade, String tags) throws InvalidArgumentException, InvalidUserException {
		
		if(idDoador == null || idDoador.trim().isEmpty()) {
			throw new InvalidArgumentException("id", "do usuario");
		}
	
		if(!usuarios.containsKey(idDoador)) {
			throw new InvalidUserException(idDoador);
		}
		
		return usuarios.get(idDoador).atualizaItem(id, quantidade, tags);
	}
	
	/**
	 * Metodo que remove um item de um determinado usuario, passado como parametro.
	 * O usuario e buscado pelo id, e caso exista, tanto o usuario como o item, o mesmo e removido.
	 * 
	 * @param id identificador do item a ser removido.
	 * @param idDoador identificador do usuario que possui o item a ser removido.
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso algum dos dados informados sejam nulos ou invalidos.
	 * @throws InvalidUserException Essa excecao eh gerada caso o usuario que disponibilizou o item nao seja encontrado.
	 * 
	 */
	public void removeItemParaDoacao(String id, String idDoador) throws Exception {
		
		
		if (idDoador == null || idDoador.trim().isEmpty()) {
			throw new InvalidArgumentException("id", "do usuario");
		} 
		if (!usuarios.containsKey(idDoador)) {
			throw new InvalidUserException(idDoador);
		}
		
		usuarios.get(idDoador).removeItemParaDoacao(id);
	}

	/**
	 * Metodo que lista todos os descritores cadastrados no sistema, independente se os mesmos possuem itens 
	 * associados ou nao.
	 * 
	 * @return Retorna uma representacao com todos os descritores do sistema, ordenados alfabeticamente.
	 * 
	 */
	public String listaDescritorDeItensParaDoacao() {
		
		if(descritores.isEmpty())
			throw new NullPointerException("Erro: Nao ha Itens nem Descritores cadastrados no sistema.");
		
		List<String> descritoresOrdenados = new ArrayList<>();
		
		for (String descritor : descritores) {
			
			descritoresOrdenados.add(descritor);
		}
		
		Collections.sort(descritoresOrdenados);
		
		ArrayList<Item> itensDoSistema = obterTodosOsItens();
		
		return listarTodosOsDescritores(descritoresOrdenados,itensDoSistema);
		
	}

	private String listarTodosOsDescritores(List<String> descritoresOrdenados, ArrayList<Item> itensDoSistema) {
		
		String retorno = "";
		
		LOOP_EXTERNO : for(int i = 0; i < descritoresOrdenados.size(); i++) {
			
			for(Item item : itensDoSistema) {
				
				if(item.getDescritor().equals(descritoresOrdenados.get(i))) {
					
					if(i == 0) {
						retorno += String.format("%d - %s",item.getQuantidade(),item.getDescritor());
						continue LOOP_EXTERNO;
					}
					
					retorno += String.format(" | %d - %s",item.getQuantidade(),item.getDescritor());
					continue LOOP_EXTERNO;
				}
			}
			
			if(i == 0) {
				retorno += String.format("0 - %s",descritoresOrdenados.get(i));
			}
			else
				retorno += String.format(" | 0 - %s",descritoresOrdenados.get(i));
		}
		
		return retorno;
	}

	private ArrayList<Item> obterTodosOsItens() {
		
		ArrayList<Item> retorno = new ArrayList<>();
		
		for(Usuario usuario : usuarios.values()) {
			
			retorno.addAll(usuario.obterItens());
		}
		
		return retorno;
	}

	/**
	 * @return
	 */
	public String listaItensParaDoacao(String classe) {
		
		HashMap<String,String> usuariosEitens = new HashMap<>();
		List<Item> itens = new ArrayList<>();
		
		for (Usuario usuario : usuarios.values()) {
			
			if(usuario.getStatus().equals(classe)) {
				
				ArrayList<Item> itensDoUsuario = usuario.obterItens();
				
				for(Item item : itensDoUsuario) {
					
					usuariosEitens.put(item.getId(),usuario.getIdentificacao());
				}
				itens.addAll(itensDoUsuario);
			}
		}
		
		if(itens.size() == 0)
			throw new NullPointerException("Erro: Nao ha itens cadastrados");
		
		if(classe.equals("doador"))
			Collections.sort(itens,new ComparadorItemPorQuantidade());
		else
			Collections.sort(itens,new ComparadorItemPorId());
		
		Usuario user0 = usuarios.get(usuariosEitens.get(itens.get(0).getId()));
		String retorno = itens.get(0).toString() + String.format(", %s: %s/%s",user0.getStatus(),user0.getNome(),user0.getIdentificacao());
		
		for(int i = 1; i < itens.size(); i++) {
			
			Usuario userI = usuarios.get(usuariosEitens.get(itens.get(i).getId()));
			retorno += " | " + itens.get(i).toString() + String.format(", %s: %s/%s",userI.getStatus(),userI.getNome(),userI.getIdentificacao());
		
		}
		return retorno;
	}
	
	/**
	 * Metodo que procura itens com descritores que contenham um trecho passado como parametro
	 * Pesquisa em todos os usuarios e retorna todos os itens encontrados
	 * @param desc trecho do descritor do item a ser procurado
	 * @return representacao textual dos itens achados
	 * @throws InvalidArgumentException excecao caso o parametro seja nulo ou vazio
	 */
	public String pesquisaItemParaDoacaoPorDescricao(String desc) throws InvalidArgumentException {
		if(desc == null || desc.trim().isEmpty())
			throw new InvalidArgumentException("texto da pesquisa");
		
		ArrayList<Item> itensListados = new ArrayList<>();
		Set<String> usuariosChaves =usuarios.keySet();
		
		for (String chave : usuariosChaves) {
			itensListados.addAll(usuarios.get(chave).pesquisaItemParaDoacaoPorDescricao(desc));
			
		}
		
		String pesquisa = "";
		ComparadorItemPorDescricao comparator = new ComparadorItemPorDescricao();
		Collections.sort(itensListados, comparator);
		for (int i = 0; i < itensListados.size(); i++) {
			if (i == itensListados.size() -1) {
				pesquisa += itensListados.get(i);
			} else {
				pesquisa += itensListados.get(i) + " | ";
			}
		}	
		
		
		return pesquisa;
		
	}

}
