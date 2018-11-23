package br.com.lp2.edoe.model;

import java.util.HashMap;

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

	protected String formatarId() {
		
		String[] separaId = identificacao.split("");
		
		if(separaId.length == 11) {
			
			return String.format("%s%s%s.%s%s%s.%s%s%s-%s%s",separaId[0],separaId[1],separaId[2],separaId[3],separaId[4],separaId[5],separaId[6],separaId[7],separaId[8],separaId[9],separaId[10]);
		}
		else {
			
			return String.format("%s%s.%s%s%s.%s%s%s/%s%s%s%s-%s%s",separaId[0],separaId[1],separaId[2],separaId[3],separaId[4],separaId[5],separaId[6],separaId[7],separaId[8],separaId[9],separaId[10],separaId[11],separaId[12],separaId[13]);
		}
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

	public String adicionaItem(String descricaoItem, int quantidade, String[] tagsArray) {
		
		String idDoItem = Integer.toString(descricaoItem.hashCode());
		
		Item itemnovo = new Item(descricaoItem, tagsArray, idDoItem, quantidade);
		
		for(Item item : itens.values()) {
			if (itemnovo.equals(item)) {
				item.setQuantidade(quantidade);
			}
		}
		
		itens.put(idDoItem, itemnovo);
		return idDoItem;
	}
	
	public String exibeItem(String id) {
		if (!itens.containsKey(id)) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		
		return itens.get(id).toString();
	}

	public String atualizaItem(String id, int quantidade, String tags) {
		if(!itens.containsKey(id)) {
			throw new IllegalArgumentException("Item nao encontrado: " + id + ".");
		}
		if(quantidade != 0) {
			itens.get(id).setQuantidade(quantidade);
		}
		if(tags != null) {
			itens.get(id).atualizaItem(tags);
		}
		return null;
	}

	public void removeItemParaDoacao(String id) {
		if(itens.size() == 0) {
			throw new IllegalArgumentException("O Usuário não possui itens cadastrados.");
		}
		if(!itens.containsKey(id)) {
			itens.remove(id);
		}
		throw new IllegalArgumentException("Item nao encontrado " + id + "." );
			
		
	}
	
}
