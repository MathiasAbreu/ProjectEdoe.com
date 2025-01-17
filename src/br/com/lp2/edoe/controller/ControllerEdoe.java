package br.com.lp2.edoe.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import br.com.lp2.edoe.comparators.ComparadorDoacao;
import br.com.lp2.edoe.comparators.ComparadorItemPorDescricao;
import br.com.lp2.edoe.comparators.ComparadorItemPorId;
import br.com.lp2.edoe.comparators.ComparadorItemPorQuantidade;
import br.com.lp2.edoe.comparators.ComparadorMatch;
import br.com.lp2.edoe.dao.ReceptoresDAO;
import br.com.lp2.edoe.exceptions.FileReadErrorException;
import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidItemException;
import br.com.lp2.edoe.exceptions.InvalidUserException;
import br.com.lp2.edoe.exceptions.NegativeIdException;
import br.com.lp2.edoe.model.Doacao;
import br.com.lp2.edoe.model.Item;
import br.com.lp2.edoe.model.Match;
import br.com.lp2.edoe.model.Usuario;

/**
 * Classe responsavel pelo controle e manipulacao de usuarios, descritores, itens, matchs e doacoes do sistema.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public class ControllerEdoe {
		
	private static int indiceId;
	private ControllerDao controleArquivos;
	
	private LinkedHashMap<String,Usuario> usuarios;	
	
	private HashSet<String> descritores;
	private HashMap<String,ArrayList<Item>> itensDoUsuario;
	
	private ArrayList<Doacao> registroDoacoes;
		
	/**
	 * Construtor responsavel pela construcao da instancia da classe, assim como das colecoes responsaveis pelo armazena
	 * mento dos dados, e do controller que possibilita a escrita/leitura dos dados.
	 * 
	 */
	public ControllerEdoe() {
						
		indiceId = 0;
		controleArquivos = new ControllerDao();
		
		usuarios = new LinkedHashMap<>();		
		descritores = new HashSet<>();
		itensDoUsuario = new HashMap<>();
		
		registroDoacoes = new ArrayList<>();
		
	}
	
	/**
	 * Metodo que inicia o sistema, iniciando o processo de leitura de todos os dados que esteja armazenados nos arquivos.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura de algum dos arquivos.
	 * 
	 */
	public void iniciaSistema() throws FileReadErrorException {
		
		lerUsuarios(controleArquivos.lerUsuarios());
		lerDescritores(controleArquivos.lerDescritores());
		lerItens(controleArquivos.lerUsuariosQuePossuemItens(),controleArquivos.lerItens());
		lerDoacoes(controleArquivos.lerDoacoes());
	}
	
	/**
	 * Metodo que finaliza o sistema, controlando o processo de escrita dos dados em respectivos arquivos.
	 * 
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na escrita em algum dos arquivos.
	 * 
	 */
	public void finalizaSistema() throws Exception {
		
		controleArquivos.escreverUsuarios(usuarios.values());
		controleArquivos.escreverDescritores(this.descritores);
		controleArquivos.escreverUsuariosQuePossuemItens(itensDoUsuario.keySet());
		controleArquivos.escreverItens(escreverItens());
		controleArquivos.escreverDoacoes(registroDoacoes);
		
	}
	
	private void lerDescritores(ArrayList<String> descritores) {
		
		for(String descritor : descritores)
			this.descritores.add(descritor);
	}
	
	private void lerUsuarios(ArrayList<Usuario> lerUsuarios) {
		
		for(Usuario usuario : lerUsuarios) {
			
			if(!usuarios.containsKey(usuario.getIdentificacao()))
				usuarios.put(usuario.getIdentificacao(),usuario);
		}
		
	}
	
	private void lerItens(ArrayList<String> usuariosItens,ArrayList<Item> itens) {
		
		int indice = 0;
		for(String usuario : usuariosItens) {
			
			ArrayList<Item> temp = new ArrayList<>();
			
			while(itens.get(indice) != null && indice < itens.size()) {
				temp.add(itens.get(indice));
				indice ++;
			}
			
			if(!temp.isEmpty())
				itensDoUsuario.put(usuario,temp);
			
			indice ++;
		}
	}
	
	private void lerDoacoes(ArrayList<Doacao> doacoes) {
		
		for(Doacao doacao : doacoes)
			registroDoacoes.add(doacao);
		
	}

	private ArrayList<Item> escreverItens() throws Exception{
				
		ArrayList<Item> itens = new ArrayList<>();
		
		for(String usuario : itensDoUsuario.keySet()) {
			
			for(Item item : itensDoUsuario.get(usuario))
				itens.add(item);
			itens.add(null);
		}
		
		return itens;
	}
	
	/**
	 * Metodo responsavel pelo cadastro de Usuarios do tipo {@link Usuario} Doador no sistema, ele recebe todos os parametros 
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
	 * @throws IllegalArgumentException Essa excecao eh gerada caso seja passada uma classe de usuario que nao conste no sistema.
	 * 
	 */
	public String adicionarDoador(String id, String nome, String email, String celular, String classe) throws Exception {
		
		checarNullVazio(id, "id", "do usuario");
		
		if(usuarios.containsKey(id)) {
			
			throw new InvalidUserException(id,"ja existente");
		}
		else {
			
			checarNullVazio(nome, "nome", "");
			checarNullVazio(email, "email", "");
			checarNullVazio(celular, "celular", "");
			checarNullVazio(classe, "classe", "");
			
			if(classe.equals("PESSOA_FISICA") || classe.equals("IGREJA") || classe.equals("ORGAO_PUBLICO_ESTADUAL") || classe.equals("ORGAO_PUBLICO_FEDERAL") || classe.equals("ONG") || classe.equals("ASSOCIACAO") || classe.equals("SOCIEDADE")) {
				
				usuarios.put(id, new Usuario(nome, email, celular, classe, id, "doador"));
				return id;
			}
			
			throw new IllegalArgumentException("Entrada invalida: opcao de classe invalida.");
		}
	}
	
	private void adicionarReceptores(ArrayList<String> receptores) {
		
		for (String receptor : receptores) {
			
			String[] dados = receptor.split(",");
			usuarios.put(dados[0],new Usuario(dados[1],dados[2],dados[3],dados[4],dados[0],"receptor"));
		}
	}

	/**
	 * Metodo que busca pela identificacao se determinado {@link Usuario} esta cadastrado no sistema. O metodo verifica se o numero da 
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
		checarNullVazio(id, "id", "do usuario");
		
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
		checarNullVazio(nome, "nome", "");
		
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
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public void lerReceptores(String caminho) throws FileReadErrorException {
		
		adicionarReceptores(ReceptoresDAO.lerReceptores(caminho));
	
	}
	
	/**
	 * Metodo que atualiza os dados de um {@link Usuario} do sistema. Caso um dos parametros seja nulo
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
		checarNullVazio(id, "id", "do usuario");

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
		checarNullVazio(id, "id", "do usuario");
		
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
	 * @throws FileReadErrorException Excecao gerada caso haja algum problema na leitura do arquivo.
	 * 
	 */
	public void atualizarReceptores(String caminho) throws FileReadErrorException {
		
		ArrayList<String> receptoresParaAtualizar = ReceptoresDAO.lerReceptores(caminho);
		
		for (String receptor : receptoresParaAtualizar) {
			
			String[] dados = receptor.split(",");
			
			for (String key : usuarios.keySet()) {
				
				if(usuarios.get(key).getIdentificacao().equals(dados[0])) {
					
					usuarios.remove(key);
					usuarios.put(key,new Usuario(dados[1],dados[2],dados[3],dados[4],dados[0],"receptor"));
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
		checarNullVazio(descricao, "descricao", "");
		
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
	 * @throws IllegalArgumentException Essa excecao eh gerada caso a quantidade informada seja invalida.
	 * 
	 */
	public String adicionaItem(String idDoador, String descricaoItem, int quantidade, String tags) throws Exception {
		
		checarNullVazio(idDoador, "id", "do usuario");
		checarNullVazio(descricaoItem, "descricao", "");
		
		if(quantidade <= 0)
			throw new IllegalArgumentException("Entrada invalida: quantidade deve ser maior que zero.");
		
		if(descritores.contains(descricaoItem.toLowerCase().replaceAll("\\s"," "))) { }
		else
			adicionaDescritor(descricaoItem.toLowerCase().replaceAll("\\s"," "));
		
		if(usuarios.containsKey(idDoador)) {
			
			indiceId ++; 
			
			if(!itensDoUsuario.containsKey(idDoador))
				itensDoUsuario.put(idDoador, new ArrayList<Item>());
			
			Item novoItem = new Item(descricaoItem.toLowerCase().replaceAll("\\s"," "), tags.split(","), String.valueOf(indiceId), quantidade);
			for (Item item : itensDoUsuario.get(idDoador)) {
				
				if(item.equals(novoItem)) {
					
					atualizaItem(item.getId(), idDoador, quantidade,"");
					return item.getId();
				}
			}
			itensDoUsuario.get(idDoador).add(new Item(descricaoItem.toLowerCase().replaceAll("\\s"," "), tags.split(","), String.valueOf(indiceId), quantidade));
			return String.valueOf(indiceId);
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
		checarNullVazio(idItem, "id", "do item");
		checarNullVazio(idDoador, "id", "do usuario");

		if (!usuarios.containsKey(idDoador)) {
			throw new InvalidUserException(idDoador);
		}
		
		if(itensDoUsuario.containsKey(idDoador)) {
			
			for (Item item : itensDoUsuario.get(idDoador)) {
				if(item.getId().equals(idItem)) {
					return item.toString();
					
				}
			}
		}
		throw new InvalidItemException(idItem);
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
	 * @throws InvalidArgumentException Excecao em caso do id (usuario ou item) ser nulo ou vazio.
	 * @throws InvalidUserException Excecao em caso do id (usuario ou item) nao for cadastrado no sistema.
	 * @throws NegativeIdException Excecao gerada caso o id informado seja negativo.
	 * @throws InvalidItemException Excecao gerada cado o usuario nao possua itens.
	 * 
	 */
	public String atualizaItem(String id, String idDoador, int quantidade, String tags) throws Exception {
		
		if(Integer.parseInt(id) < 0)
			throw new NegativeIdException();
		
		checarNullVazio(idDoador, "id", "do usuario");
	
		if(!usuarios.containsKey(idDoador)) {
			throw new InvalidUserException(idDoador);
		}
		
		if(itensDoUsuario.containsKey(idDoador)) {
			
			Item item = obterItem(id,idDoador);
			if(quantidade > 0) {
				
				item.setQuantidade(quantidade);
			}
					
			if(tags != null && !tags.trim().isEmpty()) {
				item.setTags(tags.split(","));
			}
			
			recolocarItem(idDoador,item);
			return item.toString();
		}
		
		throw new InvalidItemException();
	}
	
	private Item obterItem(String id, String idDoador) {
		
		for(Item item : itensDoUsuario.get(idDoador)) {
			
			if(item.getId().equals(id))
				return item;
		}
		
		throw new NullPointerException("Item nao encontrado: " + id + ".");
	}

	private void recolocarItem(String idDoador,Item novoItem) {
		
		ArrayList<Item> itens = itensDoUsuario.get(idDoador);

		for(int i = 0; i < itens.size(); i++) {
			
			if(novoItem.getId().equals(itens.get(i).getId())) {
				
				itens.remove(i);
				itens.add(novoItem);
				return;
			}
		}
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
	 * @throws InvalidItemException Essa excecao eh gerada caso um item nao seja encontrado, ou um usuario nao possua nenhum 
	 * item cadastrado.
	 * 
	 */
	public void removeItem(String id, String idDoador) throws Exception {
		
		if(Integer.parseInt(id) < 0)
			throw new NegativeIdException();
		
		checarNullVazio(idDoador, "id", "do usuario");
		
		if(usuarios.containsKey(idDoador) ) {
			
			if(!itensDoUsuario.containsKey(idDoador))
				throw new InvalidItemException();
			
			for(Item item : itensDoUsuario.get(idDoador)) {
				
				if(id.equals(item.getId())) {
					
					itensDoUsuario.get(idDoador).remove(item);
					return;
				}
			}
			
			throw new InvalidItemException(id);

		}
		
		throw new InvalidUserException(idDoador);

	}

	/**
	 * Metodo que lista todos os descritores cadastrados no sistema, independente se os mesmos possuem itens 
	 * associados ou nao.
	 * 
	 * @return Retorna uma representacao com todos os descritores do sistema, ordenados alfabeticamente.
	 * 
	 * @throws NullPointerException Excecao gerada caso nao haja descritores cadastrados no sistema.
	 * @throws InvalidArgumentException Excecao gerada caso algum dos descritores buscado nao esteja com algum problema.
	 * 
	 */
	public String listaDescritorDeItens() throws Exception {
		
		if(descritores.isEmpty())
			throw new NullPointerException("Erro: Nao ha Itens nem Descritores cadastrados no sistema.");
		
		List<String> descritoresOrdenados = new ArrayList<>();
		for (String descritor : descritores) {
			
			descritoresOrdenados.add(descritor);
		}
		
		Collections.sort(descritoresOrdenados);
				
		return listarTodosOsDescritores(descritoresOrdenados);
	}

	private int capturarQuantidade(String descritor) throws InvalidItemException {
		
		int quantidade = 0;
		for(Item item : obterTodosOsItens()) {
			
			if(item.getDescritor().equals(descritor) && usuarios.get(buscarUsuario(item.getId())).getStatus().equals("doador"))
				quantidade += item.getQuantidade();
		}
		
		return quantidade;
	}
	
	private String listarTodosOsDescritores(List<String> descritoresOrdenados) throws Exception {
		
		String retorno = "";
		
		verificarItens(descritoresOrdenados);
		
		LOOP_EXTERNO : for(int i = 0; i < descritoresOrdenados.size(); i++) {
			for(Item item : obterTodosOsItens()) {
				
				if(item.getDescritor().equals(descritoresOrdenados.get(i))) {
					
					if(i == 0) {
						retorno += String.format("%d - %s",capturarQuantidade(item.getDescritor()),item.getDescritor());
						continue LOOP_EXTERNO;
					}
					retorno += String.format(" | %d - %s",capturarQuantidade(item.getDescritor()),item.getDescritor());
					continue LOOP_EXTERNO;
				}
			}
			
			if(i == 0)
				retorno += String.format("0 - %s",descritoresOrdenados.get(i));
			else
				retorno += String.format(" | 0 - %s",descritoresOrdenados.get(i));
		}
		
		return retorno;
	}

	private void verificarItens(List<String> descritoresOrdenados) throws Exception {
		
		LOOP_EXTERNO : for(int i = 0; i < descritoresOrdenados.size(); i++) {
			
			for(Item item : obterTodosOsItens()) {
				
				if(item.getDescritor().equals(descritoresOrdenados.get(i))) {
					if(usuarios.get(buscarUsuario(item.getId())).getStatus().equals("doador"))
						continue LOOP_EXTERNO;
					
				}
			}
			
			if(!pesquisaItemPorDescricao(descritoresOrdenados.get(i)).equals("")) {
				descritoresOrdenados.remove(i);
				i = -1;
			}
		}
		
	}

	private ArrayList<Item> obterTodosOsItens() {
		
		Set<String> chaves = itensDoUsuario.keySet();
		ArrayList<Item> retorno = new ArrayList<>();
		
		for(String chave : chaves)
			retorno.addAll(itensDoUsuario.get(chave));
		
		return retorno;
	}

	/**
	 * Metodo que lista todos os itens de determinado tipo de usuario, este metodo busca todos os itens do sistema de determinados 
	 * usuarios, depois ordena-os de acordo com o criterio de ordenacao desejado, por ultimo gera uma representacao textual de todos os itens.
	 * 
	 * @param classe tipo de usuario
	 * 
	 * @return Retorna uma representacao de todos os itens de determinados usuarios.
	 * 
	 * @throws InvalidItemException Essa excecao eh gerada caso nao haja itens para serem listados.
	 * 
	 */
	public String listaItens(String classe) throws InvalidItemException {
		
		Set<String> chaves = itensDoUsuario.keySet();
		List<Item> itens = new ArrayList<>();
		
		for (String chave : chaves) {
			
			if(usuarios.get(chave).getStatus().equals(classe)) {
				
				itens.addAll(itensDoUsuario.get(chave));
				
			}
		}
		
		if(itens.size() == 0)
			throw new InvalidItemException();
		
		Collections.sort(itens,classe.equals("doador") ? new ComparadorItemPorQuantidade() : new ComparadorItemPorId());
		return gerarListagem(itens);
	}
	
	private String gerarListagem(List<Item> itens) throws InvalidItemException {
		
		Usuario user0 = usuarios.get(buscarUsuario(itens.get(0).getId()));
		String retorno = itens.get(0).toString() + String.format(", %s: %s/%s",user0.getStatus(),user0.getNome(),user0.getIdentificacao());
		
		for(int i = 1; i < itens.size(); i++) {
			
			Usuario userI = usuarios.get(buscarUsuario(itens.get(i).getId()));
			retorno += " | " + itens.get(i).toString() + String.format(", %s: %s/%s",userI.getStatus(),userI.getNome(),userI.getIdentificacao());
		
		}
		return retorno;
	}
	
	private String buscarUsuario(String idDoItem) throws InvalidItemException {
		
		Set<String> chaves = usuarios.keySet();
		
		for(String chave : chaves)
			if(itensDoUsuario.containsKey(chave))
				for(Item item : itensDoUsuario.get(chave)) {
					if(item.getId().equals(idDoItem))
						return chave;
				}
		
		throw new InvalidItemException(idDoItem);
	}
	
	/**
	 * Metodo que procura itens com descritores que contenham um trecho passado como parametro
	 * Pesquisa em todos os usuarios e retorna todos os itens encontrados
	 * 
	 * @param desc trecho do descritor do item a ser procurado
	 * 
	 * @return representacao textual dos itens achados
	 * 
	 * @throws InvalidArgumentException Excecao gerada caso o parametro seja nulo ou vazio
	 * 
	 */
	public String pesquisaItemPorDescricao(String desc) throws InvalidArgumentException {
		
		checarNullVazio(desc, "texto da pesquisa", "");
		
		ArrayList<Item> itensListados = new ArrayList<>();
		Set<String> usuariosChaves =usuarios.keySet();
		
		for (String chave : usuariosChaves) {
			
			if(itensDoUsuario.containsKey(chave))
				for(Item item : itensDoUsuario.get(chave)) {
					
					if(item.getDescritor().contains(desc))
						itensListados.add(item);
				}
		}
		
		Collections.sort(itensListados, new ComparadorItemPorDescricao());
		
		String pesquisa = "";
		for (int i = 0; i < itensListados.size(); i++) {
			
			if (i == itensListados.size() -1)
				pesquisa += itensListados.get(i);
			else
				pesquisa += itensListados.get(i) + " | ";
			
		}	
		
		return pesquisa;	
	}

	/**
	 * Encontra matches (casamentos de itens) entre itens a serem doados e itens necessarios.
	 * A partir do id do receptor e do item que o mesmo precisa, encontra possiveis doadores 
	 * que possam ofertar esse item.
	 * 
	 * @param idReceptor identificador do receptor dos itens
	 * @param idItem id do item necessario ao receptor
	 * 
	 * @return retorna os itens que combinam
	 * 
	 * @throws InvalidArgumentException excecao em caso de alguns dos parametros ser nulo ou vazio.
	 * @throws InvalidUserException Excecao gerada caso o usuario nao seja encontrado no sistema.
	 * @throws NegativeIdException Excecao gerada caso o id informado seja negativo.
	 * @throws NullPointerException Excecao gerada caso o usuario informado seja doador, e nao receptor.
	 * 
	 */
	public String match(String idReceptor, String idItem) throws Exception {
		
		checarNullVazio(idReceptor, "id", "do usuario");
		if(Integer.parseInt(idItem) < 0)
			throw new NegativeIdException();
		
		if(usuarios.containsKey(idReceptor)) {
			if(usuarios.get(idReceptor).getStatus().equals("Receptor")) {
				
				return procurarPorMatchs(idItem);
			}
			throw new NullPointerException("O Usuario deve ser um receptor: " + idReceptor + ".");
		}
		
		throw new InvalidUserException(idReceptor);
	}

	/**
	 * Procura por matchs.
	 * A partir de um identificador de item passado como parametro, retorna os matchs desse item.
	 * 
	 * @param idItem identificador do item a ser procurado pelos matches.
	 * 
	 * @return retorna os itens que casam com o id passado como parametro.
	 * 
	 */
	private String procurarPorMatchs(String idItem) throws InvalidItemException {
		
		Item retornoBusca = obterItem(idItem,buscarUsuario(idItem));
		ArrayList<Match> possiveisMatchs = new ArrayList<>();
		
		for(Item item : obterTodosOsItens()) {

			if(retornoBusca.getDescritor().equals(item.getDescritor()) && usuarios.get(buscarUsuario(item.getId())).getStatus().equals("doador")) {
				possiveisMatchs.add(new Match(retornoBusca, item));
			}
		}
		
		if(possiveisMatchs.isEmpty())
			return "";
		
		Collections.sort(possiveisMatchs, new ComparadorMatch());
		
		ArrayList<Item> itens = new ArrayList<>();
		for(Match match : possiveisMatchs)
			itens.add(match.getItem());
		
		return gerarListagem(itens);
	}
	
	/**
	 * Metodo que realiza uma doacao no sistema. Esse metodo recebe todos os parametros necessarios, dados dos itens para 
	 * serem doados e recebidos, verifica se todos os parametros sao validos e 
	 * pertencem ao sistema, e por fim realiza a doacao.
	 * 
	 * @param idItemNec id do item necessario para a doacao.
	 * @param idItemDoado id do item a ser doado
	 * @param data data da doacao
	 * 
	 * @return Retorna uma representacao textual da confirmacao, concluindo com exito o processo de doacao.
	 * 
	 * @throws NegativeIdException Excecao gerada cado um dos ids informado seja negativo.
	 * @throws InvalidArgumentException Excecao gerada caso algum dos paramteros informados seja nulo ou invalido.
	 * @throws IllegalArgumentException Excecao gerada caso os descritores dos itens sejam diferentes, impossibilitando 
	 * a doacao.
	 * 
	 */
	public String realizaDoacao(String idItemNec, String idItemDoado, String data) throws Exception {
		
		if(Integer.parseInt(idItemNec) < 0 || Integer.parseInt(idItemDoado) < 0)
			throw new NegativeIdException();
		
		checarNullVazio(idItemNec, "id", "");
		checarNullVazio(idItemDoado, "id", "");
		checarNullVazio(data, "data" ,"");
		
		String idReceptor = buscarUsuario(idItemNec);
		String idDoador = buscarUsuario(idItemDoado);	
		
		Item itemDoado = obterItem(idItemDoado, idDoador);
		Item itemNecessario = obterItem(idItemNec, idReceptor);
		
		if (!itemDoado.getDescritor().equals(itemNecessario.getDescritor())) 
			throw new IllegalArgumentException("Os itens nao tem descricoes iguais.");
		
		int quantidadeDisp = itemDoado.getQuantidade();
		int quantidadeNec = itemNecessario.getQuantidade();
		
		int quantidadeDoada;
		
		if (quantidadeDisp > quantidadeNec) {
			quantidadeDoada = quantidadeNec;
			itemDoado.setQuantidade(itemDoado.getQuantidade() - quantidadeNec);
			removeItem(idItemNec, idReceptor);
		}
		else if (quantidadeDisp == quantidadeNec) {
			quantidadeDoada = quantidadeNec;
			removeItem(idItemDoado, idDoador);
			removeItem(idItemNec, idReceptor);
		}
		else {
			quantidadeDoada = quantidadeDisp;
			removeItem(idItemDoado, idDoador);
			itemNecessario.setQuantidade(itemNecessario.getQuantidade() - quantidadeDisp);
		}
		
		Doacao doacao = new Doacao(usuarios.get(idDoador).getNome(),idDoador,usuarios.get(idReceptor).getNome(),idReceptor, data, itemDoado.getDescritor(), quantidadeDoada);
		registroDoacoes.add(doacao);
		
		return doacao.toString();
	}
	
	/**
	 * Metodo que retorna todas as doacoes realizadas.
	 * 
	 * @return Uma string com informacoes de todas as doacoes, organizadas pela data de doacao.
	 * 
	 * @throws NullPointerException Excecao gerada caso nao ha doadoes registradas no sistema.
	 * 
	 */
	public String listaDoacoes() {
		
		if(registroDoacoes.isEmpty())
			throw new NullPointerException("Nao ha doacoes registradas!");
		
		Collections.sort(registroDoacoes, new ComparadorDoacao());
		
		String retorno = registroDoacoes.get(0).toString();
		
		for(int i = 1;i < registroDoacoes.size(); i++)
			retorno += " | " + registroDoacoes.get(i).toString();
		
		return retorno;
	}
	
	private void checarNullVazio(String valor, String parametro, String adicional) throws InvalidArgumentException {
		
		if (adicional.equals(""))
			if (valor == null || valor.trim().isEmpty())
				throw new InvalidArgumentException(parametro);
		
		if (valor == null || valor.trim().isEmpty())
			throw new InvalidArgumentException(parametro, adicional);
	}
	
}