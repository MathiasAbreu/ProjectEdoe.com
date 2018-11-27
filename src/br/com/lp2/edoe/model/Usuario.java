package br.com.lp2.edoe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import br.com.lp2.edoe.exceptions.InvalidArgumentException;
import br.com.lp2.edoe.exceptions.InvalidUserException;

/**
 * Classe que representa uma abstracao de um Usuario no sistema, eh uma classe basica que fornece atributos e metodos 
 * basicos para as classes especializadas deste mesmo tipo de Usuario.
 *
 * @author Caio Fernandes Moreira - caio.moreira@ccc.ufcg.edu.br
 * @author Klaywert Danillo Ferreira De Souza - klaywert.souza@ccc.ufcg.edu.br
 * @author Mathias Abreu Trajano - mathias.trajano@ccc.ufcg.edu.br
 *
 */
public abstract class Usuario {

	private String nome;
	private String email;
	private String celular;
	private String classe;
	private String identificacao;
	
	private HashMap<String, Item> itens;
	
			
	/**
	 * Construtor reponsavel por instanciar um novo Usuario, ele recebe todos os parametros necessarios para preencher 
	 * os atributos basicos de um Usuario.
	 * 
	 * @param nome nome do usuario
	 * @param email email do usuario
	 * @param celular celular do usuario
	 * @param classe classe do usuario
	 * @param identificacao numero de identificacao do usuario
	 * 
	 */
	public Usuario(String nome, String email, String celular, String classe,String identificacao) {
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.classe = classe;
		this.identificacao = identificacao;
		
		itens = new HashMap<>();
	}

	/**
	 * Metodo que retorna o nome do Usuario.
	 * 
	 * @return O nome do usuario.
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que altera o nome do Usuario.
	 * 
	 * @param nome O novo nome do usuario.
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que retorna o email do Usuario.
	 * 
	 * @return O email do usuario.
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que altera o email do Usuario.
	 * 
	 * @param email O novo email do usuario.
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna o celular do Usuario.
	 * 
	 * @return O celular do Usuario.
	 *
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Metodo que altera o celular do Usuario.
	 * 
	 * @param celular O novo celular do Usuario.
	 * 
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Metodo que retorna a classe do Usuario.
	 * 
	 * @return A classe do Usuario.
	 * 
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * Metodo que retorna o numero de identificacao do Usuario.
	 * 
	 * @return O numero de identificacao do Usuario.
	 * 
	 */
	public String getIdentificacao() {
		return identificacao;
	}

	/**
	 * Metodo responsavel por gerar um numero de identificao que pode ser usado internamente para armazenar o usuario em 
	 * alguma colecao de armazenamento especifica.
	 * 
	 * @return Retorna o numero usado para armazenar em determinado indice.
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		return result;
	}

	/**
	 * Metodo responsevel por verificar se dois usuarios sao iguais baseado nos seus documentos de identificao.
	 * 
	 * @param obj Recebe como parametro qualquer objeto.
	 * 
	 * @return Retorna uma confirmacao ou nao da igualdade entre dois Usuarios.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		
		if(this.getClass() == obj.getClass()) {
			
			Usuario other = (Usuario) obj;
			
			if(this.identificacao.equals(other.getIdentificacao()))
				return true;
			
		}
		
		return false;
	}
	
	/**
	 * Metodo que gera e retorna uma representacao textual do Usuario.
	 * 
	 * @return Retorna a representacao textual do Usuario.
	 * 
	 */
	@Override
	public abstract String toString();

	/**
	 * Metodo que adiciona um novo item ao usuario.
	 * 
	 * @param descricaoItem descricao do item.
	 * @param quantidade quantidade deisponivel do item
	 * @param tagsArray tags do novo item
	 * 
	 * @return Retorna o id unico gerado para o novo item.
	 */
	public String adicionaItem(String descricaoItem, int quantidade, String[] tagsArray) {
		
		int id = descricaoItem.hashCode();
		String idDoItem = Integer.toString(id > 0 ? id : id * -1);
		
		Item itemnovo = new Item(descricaoItem, tagsArray, idDoItem, quantidade);
		
		for(Item item : itens.values()) {
			if (itemnovo.equals(item)) {
				item.setQuantidade(quantidade);
			}
		}
		
		itens.put(idDoItem, itemnovo);
		return idDoItem;
	}
	
	/**
	 * Metodo que busca e exibe um item de tal usuario.
	 * 
	 * @param id id unico do item a ser buscado.
	 * 
	 * @return Retorna, se encontrado, a representacao textual de tal item.
	 * 
	 * @throws IllegalArgumentException Excecao gerada caso o item desejado nao seja encontrado.
	 * 
	 */
	public String exibeItem(String id) {
		if (!itens.containsKey(id)) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		
		return itens.get(id).toString();
	}
	
	/**
	 * Atualiza um item passado como parametro. Pode ser alterado quantidade e tags do item.
	 *  
	 * @param id identificador do item
	 * @param quantidade nova quantidade de itens oferecidos
	 * @param tags novas tags de identificacao do item
	 * 
	 * @return Representacao textual do item atualizado
	 * 
	 * @throws IllegalArgumentException Essa excecao eh gerada caso o id inserido seja negativo ou o item nao seja encontrado.
	 * 
	 */
	public String atualizaItem(String id, int quantidade, String tags) {
		
		if(Integer.parseInt(id) < 0)
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		if(!itens.containsKey(id)) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		if(quantidade != 0) {
			itens.get(id).setQuantidade(quantidade);
		}
		
		if(tags != null && !tags.trim().isEmpty()) {
			itens.get(id).setTags(tags.split(","));
		}
		
		return itens.get(id).toString();
	}
	
	/**
	 * Remove um item, usando seu idenficador unico. 
	 * 
	 * @param id identificador do item a ser removido
	 * 
	 * @throws IllegalArgumentException Caso o usuario nao possua itens ou o id nao exista, essa excecao eh gerada.
	 * 
	 */
	public void removeItemParaDoacao(String id) {
		
		if(Integer.parseInt(id) < 0)
			throw new IllegalArgumentException("Entrada invalida: id do item nao pode ser negativo.");
		
		if(itens.size() == 0) {
			throw new IllegalArgumentException("O Usuario nao possui itens cadastrados.");
		}
		
		if(itens.containsKey(id)) {

			itens.remove(id);
		}
		else
			throw new IllegalArgumentException("Item nao encontrado: " + id + "." );
			
		
	}

	/**
	 * Metodo que retorna uma colecao com todos os itens do usuario.
	 * 
	 * @return Retorna uma colecao com todos os itens do usuario.
	 * 
	 */
	public ArrayList<Item> obterItens() {
		
		ArrayList<Item> itensParaRetornar = new ArrayList<>();
		
		for(Item item : itens.values())
			itensParaRetornar.add(item);
		
		return itensParaRetornar;
	}
	
	/**
	 * Pesquisa um item atraves de um descritor passado como parametro
	 * Checa os itens disponibilizados pelo usuario e adiciona a lista caso ache
	 * @param desc descritor a ser procurado
	 * @return uma lista contendo os itens que possuem o descritor passado como parametro
	 */
	public ArrayList<Item> pesquisaItemParaDoacaoPorDescricao(String desc) {
		Set<String> itensTodos = itens.keySet();
		ArrayList<Item> itensAchados = new ArrayList<>();
		for (String item : itensTodos) {
			if (itens.get(item).getDescritor().toLowerCase().contains(desc.toLowerCase())) {
				itensAchados.add(itens.get(item));
			}
		}
		
		return itensAchados;
	}
	
}
